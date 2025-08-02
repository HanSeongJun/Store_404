package Store404.backend.Controller.Category;

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
    
    @GetMapping
    public List<CategoryRequestDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<? super CategoryResponseDto> getCategoryById(@PathVariable Long id, CategoryRequestDto dto) {
        return categoryService.getCategoryById(id, dto);
    }

    @PostMapping
    public ResponseEntity<? super CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto dto) {
        return categoryService.createCategory(dto);
    }
}
