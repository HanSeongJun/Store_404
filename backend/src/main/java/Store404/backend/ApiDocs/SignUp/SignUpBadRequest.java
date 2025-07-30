package Store404.backend.ApiDocs.SignUp;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class SignUpBadRequest extends ResponseDto {

    @Schema(description = "DE, DT")
    private String code;

    @Schema(description = "Duplicate Email. / Duplicate Tel Number.")
    private String message;

    public SignUpBadRequest(String code, String message) {
        super(code, message);
    }
}
