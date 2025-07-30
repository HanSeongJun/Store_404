package Store404.backend.Dto.Response.Auth;

import Store404.backend.Common.ResponseCode;
import Store404.backend.Common.ResponseMessage;
import Store404.backend.Dto.Request.Auth.LoginRequestDto;
import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Schema(description = "로그인 응답 DTO")
public class LoginResponseDto extends ResponseDto{

    private String token;
    private int expirationTime;

    private LoginResponseDto(String token) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.token = token;
        this.expirationTime = 3600; // 토큰 만료 시간 = 1시간
    }

    public static ResponseEntity<LoginResponseDto> success(String token) {
        LoginResponseDto result = new LoginResponseDto(token);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> signInFail() {
        ResponseDto result = new ResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
