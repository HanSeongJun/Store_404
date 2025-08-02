package Store404.backend.Dto.Request.Category;

import Store404.backend.Entity.Category.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "카테고리 요청 DTO")
public class CategoryRequestDto {

    @NotBlank
    @Schema(description = "카테고리 아이디", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "카테고리 이름", example = "전자제품")
    private String name;

    @Schema(description = "카테고리 설명", example = "전자제품 카테고리 입니다.")
    private String description;

    @Schema
    public static CategoryRequestDto from(Category category) {
        return CategoryRequestDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
