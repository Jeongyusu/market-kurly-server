package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutJPARepository extends JpaRepository<Product, Integer> {


    int countByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now);

    Page<Product> findByProductUploadedAtBetween(LocalDate monthAgo, LocalDate now, Pageable pageable);

    Page<Product> findByCategory_Id(Integer categoryId, Pageable pageable);

    int countByCategory_Id(Integer categoryId);
}
