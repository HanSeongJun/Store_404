package Store404.backend.ApiDocs;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class InternalServerError extends ResponseDto {

    @Schema(description = "DBE")
    private String code;

    @Schema(description = "Database Error.")
    private String message;

    public InternalServerError(String code, String message) {
        super(code, message);
    }
}
