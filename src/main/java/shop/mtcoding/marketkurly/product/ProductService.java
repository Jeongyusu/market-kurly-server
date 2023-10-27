package shop.mtcoding.marketkurly.product;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.option.OptionJPARepository;
import shop.mtcoding.marketkurly.product.ProductResponse.ProductMainDTO;
import shop.mtcoding.marketkurly.review.Review;
import shop.mtcoding.marketkurly.review.ReviewJPARepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProdcutJPARepository prodcutJPARepository;
    private final ReviewJPARepository reviewJPARepository;
    private final OptionJPARepository optionJPARepository;

    // page: 0, 1, 2
    public ProductMainDTO 컬리추천(int page) {
        Page<Product> products = prodcutJPARepository.findAll(PageRequest.of(page, 5));
        List<ProductResponse.ProductSummary> productSummaryList = products.stream()
                .map(product -> {
                    double averageStarCount = reviewJPARepository.findByProduct(product).stream()
                            .mapToInt(Review::getStarCount)
                            .average()
                            .orElse(0);
                    Option option = optionJPARepository.findTopByProductOrderByOptionPriceAsc(product).orElseThrow();
                    return new ProductResponse.ProductSummary(product, Math.round(averageStarCount * 10) / 10.0,
                            option);
                })
                .collect(Collectors.toList());

        return new ProductMainDTO(productSummaryList);

    }
}
