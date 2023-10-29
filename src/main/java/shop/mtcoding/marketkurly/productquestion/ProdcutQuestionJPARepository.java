package shop.mtcoding.marketkurly.productquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdcutQuestionJPARepository extends JpaRepository<ProductQuestion, Integer> {
    List<ProductQuestion> findByOptionId(Integer optionId);
}