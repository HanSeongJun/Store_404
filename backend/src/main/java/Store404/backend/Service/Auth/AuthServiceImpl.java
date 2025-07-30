package Store404.backend.Service.Auth;

import Store404.backend.Dto.Request.Auth.SignUpRequestDto;
import Store404.backend.Dto.Response.Auth.SignUpResponseDto;
import Store404.backend.Entity.User.User;
import Store404.backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    // 비밀번호 암호화 인터페이스 주입
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {

            // 이미 존재하는 이메일인지 검증
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if (existedEmail) return SignUpResponseDto.duplicateEmail();

            // 이미 존재하는 전화번호인지 검증
            String telNumber = dto.getPhone();
            boolean existedTelNumber = userRepository.existsByPhone(telNumber);
            if (existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            // 비밀번호 암호화
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            // 회원정보 저장
            User user = User.builder()
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .name(dto.getName())
                    .phone(dto.getPhone())
                    .address(dto.getAddress())
                    .build();

            userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace();
            return SignUpResponseDto.databaseError();

        }

        return SignUpResponseDto.success();
    }
}
