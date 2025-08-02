package Store404.backend.Service.Category;

import Store404.backend.Dto.Request.Category.CategoryRequestDto;
import Store404.backend.Dto.Response.Category.CategoryResponseDto;
import Store404.backend.Entity.Category.Category;
import Store404.backend.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    // 카테고리 조회
    @Override
    public List<CategoryRequestDto> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryRequestDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<? super CategoryResponseDto> getCategoryById(Long id, CategoryRequestDto dto) {

        try {

            // 해당 ID의 카테고리가 존재하는지 확인
            Category category = categoryRepository.findById(id)
                    .orElse(null);

            // 카테고리가 존재하지 않는 경우
            if (category == null) {
                return CategoryResponseDto.notExistedCategory();
            }

            // 성공 응답 반환 - 카테고리 데이터와 함께
            CategoryRequestDto categoryData = CategoryRequestDto.from(category);
            return CategoryResponseDto.success(categoryData);

        } catch (Exception e) {
            e.printStackTrace();
            return CategoryResponseDto.databaseError();
        }
    }

    // 카테고리 추가
    @Transactional
    @Override
    public ResponseEntity<? super CategoryResponseDto> createCategory(CategoryRequestDto dto) {

        try {

            // 이미 존재하는 카테고리 이름인 경우
            if (categoryRepository.existsByName(dto.getName())) {
                return CategoryResponseDto.duplicateCategory();
            }

            Category category = Category.builder()
                    .name(dto.getName())
                    .description(dto.getDescription())
                    .build();

           categoryRepository.save(category);

           // 생성된 카테고리 데이터를 응답에 포함
           CategoryRequestDto createdCategoryData = CategoryRequestDto.from(category);
           return CategoryResponseDto.success(createdCategoryData);

        } catch (Exception e) {
            e.printStackTrace();
            return CategoryResponseDto.databaseError();
        }
    }

    @Transactional
    @Override
    public ResponseEntity<? super CategoryResponseDto> updateCategory(Long id, CategoryRequestDto dto) {

        try {

            // 해당 ID의 카테고리가 존재하는지 확인
            Category category = categoryRepository.findById(id)
                    .orElse(null);

            // 카테고리가 존재하지 않는 경우
            if (category == null) {
                return CategoryResponseDto.notExistedCategory();
            }

            // 이름이 변경되었고, 그 이름이 다른 카테고리에서 이미 사용 중인지 확인
            if (!category.getName().equals(dto.getName()) &&
                    categoryRepository.existsByName(dto.getName())) {
                return CategoryResponseDto.duplicateCategory();
            }

            // 필드 값 수정
            category.setName(dto.getName());
            category.setDescription(dto.getDescription());

            categoryRepository.save(category);

            // 수정된 카테고리 데이터를 응답에 포함
            CategoryRequestDto updatedCategoryData = CategoryRequestDto.from(category);
            return CategoryResponseDto.success(updatedCategoryData);

        } catch (Exception e) {
            e.printStackTrace();
            return CategoryResponseDto.databaseError();
        }
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
