package Store404.backend.ApiDocs.Category.Create;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreateCategoryBadRequest extends ResponseDto {

    @Schema(description = "DCN")
    private String code;

    @Schema(description = "Duplicate Category Name.")
    private String message;

    public CreateCategoryBadRequest(String code, String message) {
        super(code, message);
    }
}
