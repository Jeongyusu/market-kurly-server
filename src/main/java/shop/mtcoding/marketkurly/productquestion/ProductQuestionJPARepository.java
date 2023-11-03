package shop.mtcoding.marketkurly.productquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductQuestionJPARepository extends JpaRepository<ProductQuestion, Integer> {
    List<ProductQuestion> findByProductId(Integer productId);
}
