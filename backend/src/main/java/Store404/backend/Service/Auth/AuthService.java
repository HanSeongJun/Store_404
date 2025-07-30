package Store404.backend.Service.Auth;

import Store404.backend.Dto.Request.Auth.LoginRequestDto;
import Store404.backend.Dto.Request.Auth.SignUpRequestDto;
import Store404.backend.Dto.Response.Auth.LoginResponseDto;
import Store404.backend.Dto.Response.Auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super LoginResponseDto> logIn(LoginRequestDto dto);
}
