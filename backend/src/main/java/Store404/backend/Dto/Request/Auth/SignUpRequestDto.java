package Store404.backend.Dto.Request.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원가입 요청 DTO")
public class SignUpRequestDto {

    @NotBlank
    @Email
    @Schema(description = "이메일 주소", example = "user@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank
    @Size(min = 6)
    @Schema(description = "비밀번호", example = "dkssud12", minLength = 6, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    @Schema(description = "이름", example = "홍길동", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[0-9]{11,13}$")
    @Schema(description = "휴대폰 번호", example = "01012345678", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

    @NotBlank
    @Schema(description = "주소", example = "서울 강남구 테헤란로 123")
    private String address;
}
