package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutJPARepository extends JpaRepository<Product, Integer> {

    Page<Product> findByRegistrationDateAfter(LocalDate oneMonthAgo, PageRequest of);

    Page<Product> findAllByOrderBySalesDesc(PageRequest of);

}
