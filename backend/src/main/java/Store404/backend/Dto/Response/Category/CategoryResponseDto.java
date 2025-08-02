package Store404.backend.Dto.Response.Category;

import Store404.backend.Common.ResponseCode;
import Store404.backend.Common.ResponseMessage;
import Store404.backend.Dto.Request.Category.CategoryRequestDto;
import Store404.backend.Dto.Response.Auth.LoginResponseDto;
import Store404.backend.Dto.Response.ResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Schema(description = "카테고리 응답 DTO")
public class CategoryResponseDto extends ResponseDto {

    @Schema(description = "카테고리 데이터")
    private CategoryRequestDto data;

    public CategoryResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public CategoryResponseDto(CategoryRequestDto data) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.data = data;
    }

    public static ResponseEntity<CategoryResponseDto> success() {
        CategoryResponseDto result = new CategoryResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<CategoryResponseDto> success(CategoryRequestDto data) {
        CategoryResponseDto result = new CategoryResponseDto(data);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> duplicateCategory() {
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_CATEGORY_NAME, ResponseMessage.DUPLICATE_CATEGORY_NAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistedCategory() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_CATEGORY, ResponseMessage.NOT_EXIST_CATEGORY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
