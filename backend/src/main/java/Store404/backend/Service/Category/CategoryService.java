package Store404.backend.Service.Category;

import Store404.backend.Dto.Request.Category.CategoryRequestDto;
import Store404.backend.Dto.Response.Auth.LoginResponseDto;
import Store404.backend.Dto.Response.Category.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryRequestDto> getAllCategories();
    ResponseEntity<? super CategoryResponseDto> getCategoryById(Long id, CategoryRequestDto dto);
    ResponseEntity<? super CategoryResponseDto> createCategory(CategoryRequestDto dto);
    ResponseEntity<? super CategoryResponseDto> updateCategory(Long id, CategoryRequestDto dto);
    void deleteCategory(Long id);
}