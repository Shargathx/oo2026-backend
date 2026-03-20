package ee.msaareva.veebipood.repository;

import ee.msaareva.veebipood.entity.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

// Non-null type argument is expected.
// Spring Boot 4.0

public interface CategoryRepository extends JpaRepository<@NonNull Category,@NonNull Long> {
}
