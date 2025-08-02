package Store404.backend.ApiDocs.Category.Update;

import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class UpdateCategoryBadRequest extends ResponseDto
{
    @Schema(description = "NC")
    private String code;

    @Schema(description = "NOT_EXIST_CATEGORY")
    private String message;

    public UpdateCategoryBadRequest(String code, String message) {
        super(code, message);
    }
}
