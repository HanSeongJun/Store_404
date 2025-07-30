package Store404.backend.ApiDocs;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class Success extends ResponseDto {

    @Schema(description = "SU")
    private String code;

    @Schema(description = "Success")
    private String message;

    public Success(String code, String message) {
        super(code, message);
    }
}
