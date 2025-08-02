package Store404.backend.Repository;

import Store404.backend.Entity.Category.Category;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean findByName(String name);
    boolean existsByName(String name);
}
