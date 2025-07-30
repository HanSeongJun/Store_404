package Store404.backend.Controller.Auth;

import Store404.backend.ApiDocs.SignUp.SignUpApiDocs;
import Store404.backend.Dto.Request.Auth.SignUpRequestDto;
import Store404.backend.Dto.Response.Auth.SignUpResponseDto;
import Store404.backend.Service.Auth.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "User", description = "회원가입, 로그인 API")
public class AuthController {

    private final AuthService authService;

    @SignUpApiDocs
    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody) {
        return authService.signUp(requestBody);
    }
}
