package shop.mtcoding.marketkurly.waitingproduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingProductJPARepository extends JpaRepository<WaitingProduct, Integer> {

    List<WaitingProduct> findBySellerId(Integer userId);

}
