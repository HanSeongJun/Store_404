package Store404.backend.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = parseBearerToken(request); // 요청으로부터 parseBearerToken()을 통해 토큰 가져오기

            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String email = jwtProvider.validate(token);
            if (email == null) {
                filterChain.doFilter(request, response);
                return;
            }

            // 사용자 정보를 바탕으로 인증 토큰 생성, 현재는 권한 정보가 없기 때문에 NO_AUTHORITIES 사용
            AbstractAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 웹 인증 세부정보 소스

            // 인증 정보에 접근하기위해 컨텍스트에 인증 토큰 저장.
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        } catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

    // 요청으로부터 JWT 토큰 추출
    private String parseBearerToken(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");

        // 길이가 0이거나, 공백이거나, null 로 채워진 경우 false
        boolean hasAuthorization = StringUtils.hasText(authorization);
        if (!hasAuthorization) return null;

        // Bearer 로 시작하지 않는 토큰인경우 false
        boolean isBearer = authorization.startsWith("Bearer ");
        if (!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }
}
