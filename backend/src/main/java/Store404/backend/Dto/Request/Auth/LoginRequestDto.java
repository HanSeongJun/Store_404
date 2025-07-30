package Store404.backend.Dto.Request.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "로그인 요청 DTO")
public class LoginRequestDto {

    @NotBlank
    @Email
    @Schema(description = "이메일 주소", example = "user@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank
    @Size(min = 6)
    @Schema(description = "비밀번호", example = "dkssud12", minLength = 6, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
