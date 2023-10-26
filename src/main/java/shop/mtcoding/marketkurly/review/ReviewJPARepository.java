package shop.mtcoding.marketkurly.review;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.marketkurly.product.Product;

import java.util.List;

public interface ReviewJPARepository extends JpaRepository<Review, Integer> {

    List<Review> findByProduct(Product product);
}
