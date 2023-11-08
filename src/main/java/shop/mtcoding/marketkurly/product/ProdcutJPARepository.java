package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutJPARepository extends JpaRepository<Product, Integer> {

    int countByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now);

    Page<Product> findByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now, Pageable pageable);

    Page<Product> findByCategoryId(Integer categoryId, Pageable pageable);

    int countByCategoryId(Integer categoryId);

    @EntityGraph(attributePaths = { "seller" })
    Optional<Product> findById(Integer productId);

    List<Product> findBySellerId(Integer userId);
}
