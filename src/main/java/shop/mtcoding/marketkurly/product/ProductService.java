package shop.mtcoding.marketkurly.product;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.marketkurly.product.ProductResponse.ProductMainDTO;
import shop.mtcoding.marketkurly.review.Review;
import shop.mtcoding.marketkurly.review.ReviewJPARepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProdcutJPARepository prodcutJPARepository;
    private final ReviewJPARepository reviewJPARepository;

    // page: 0, 1, 2
    public ProductMainDTO 메인홈(int page) {
        Page<Product> products = prodcutJPARepository.findAll(PageRequest.of(page, 5));
        List<ProductResponse.ProductSummary> productSummaryList = products.stream()
                .map(product -> {
                            double averageStarCount = reviewJPARepository.findByProduct(product).stream()
                                    .mapToInt(Review::getStarCount)
                                    .average()
                                    .orElse(0);
                            return new ProductResponse.ProductSummary(product, Math.round(averageStarCount * 10) / 10.0);
                        }
                )
                .collect(Collectors.toList());

        return new ProductMainDTO(productSummaryList);
    }

}
