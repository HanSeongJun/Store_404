package Store404.backend.ApiDocs.Auth.LogIn;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class LoginBadRequest extends ResponseDto {

    @Schema(description = "VF")
    private String code;

    @Schema(description = "Validation failed.")
    private String message;


    public LoginBadRequest(String code, String message) {
        super(code, message);
    }
}
