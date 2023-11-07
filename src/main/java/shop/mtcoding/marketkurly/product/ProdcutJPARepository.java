package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shop.mtcoding.marketkurly.product.ProductResponse.ProductAvgStar;

public interface ProdcutJPARepository extends JpaRepository<Product, Integer> {

    int countByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now);

    Page<Product> findByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now, Pageable pageable);

    Page<Product> findByCategory_Id(Integer categoryId, Pageable pageable);

    int countByCategoryId(Integer categoryId);

    @EntityGraph(attributePaths = { "seller" })
    Optional<Product> findById(Integer productId);

    List<Product> findBySellerId(Integer userId);

    @Query(value = "SELECT product_id " +
            "FROM review_tb " +
            "GROUP BY product_id " +
            "ORDER BY avg_star_count DESC", nativeQuery = true)
    List<Product> getProductAvgStars();

}
