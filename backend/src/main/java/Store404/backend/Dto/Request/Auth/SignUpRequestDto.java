package Store404.backend.Dto.Request.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    // ===== 회원가입 요청  DTO ===== //
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Pattern(regexp = "^[0-9]{11,13}$")
    private String phone;

    @NotBlank
    private String address;
}
