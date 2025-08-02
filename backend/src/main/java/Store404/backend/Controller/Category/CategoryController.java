package Store404.backend.Controller.Category;

import Store404.backend.ApiDocs.Category.Create.CreateCategoryApiDocs;
import Store404.backend.ApiDocs.Category.Delete.DeleteCategoryApiDocs;
import Store404.backend.ApiDocs.Category.Update.UpdateCategoryApiDocs;
import Store404.backend.ApiDocs.Category.getAll.GetAllCategoryApiDocs;
import Store404.backend.ApiDocs.Category.getById.GetCategoryByIdApiDocs;
import Store404.backend.Dto.Request.Category.CategoryRequestDto;
import Store404.backend.Dto.Response.Category.CategoryResponseDto;
import Store404.backend.Service.Category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @GetAllCategoryApiDocs
    @GetMapping
    public List<CategoryRequestDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetCategoryByIdApiDocs
    @GetMapping("/{id}")
    public ResponseEntity<? super CategoryResponseDto> getCategoryById(@PathVariable Long id, CategoryRequestDto dto) {
        return categoryService.getCategoryById(id, dto);
    }

    @CreateCategoryApiDocs
    @PostMapping
    public ResponseEntity<? super CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto dto) {
        return categoryService.createCategory(dto);
    }

    @UpdateCategoryApiDocs
    @PutMapping("/{id}")
    public ResponseEntity<? super CategoryResponseDto> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDto dto) {
        return categoryService.updateCategory(id, dto);
    }

    @DeleteCategoryApiDocs
    @DeleteMapping("/{id}")
    public ResponseEntity<? super CategoryResponseDto> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }
}
