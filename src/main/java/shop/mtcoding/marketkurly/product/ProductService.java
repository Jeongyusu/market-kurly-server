package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.option.OptionJPARepository;
import shop.mtcoding.marketkurly.product.ProductResponse.ProductMainDTO;
import shop.mtcoding.marketkurly.product.ProductResponse.bestProductDTO;
import shop.mtcoding.marketkurly.product.ProductResponse.newProductDTO;
import shop.mtcoding.marketkurly.review.Review;
import shop.mtcoding.marketkurly.review.ReviewJPARepository;

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

    public newProductDTO 신상품(int page) {
    // 한 달 전의 날짜 계산
    LocalDate oneMonthAgo = LocalDate.now().minus(1, ChronoUnit.MONTHS);

    // 한 달 이내의 상품만 가져오도록 쿼리 작성
    Page<Product> products = prodcutJPARepository.findByRegistrationDateAfter(oneMonthAgo, PageRequest.of(page, 5));

    List<ProductResponse.ProductSummary> productSummaryList = products.stream()
            .map(product -> {
                double averageStarCount = reviewJPARepository.findByProduct(product).stream()
                        .mapToInt(Review::getStarCount)
                        .average()
                        .orElse(0);
                Option option = optionJPARepository.findTopByProductOrderByOptionPriceAsc(product).orElseThrow();
                return new ProductResponse.ProductSummary(product, Math.round(averageStarCount * 10) / 10.0, option);
            })
            .collect(Collectors.toList());

    return new newProductDTO(productSummaryList);
}

       
    

public bestProductDTO 베스트(int page) {
    // 판매량을 기준으로 상품을 내림차순으로 정렬하여 가져옵니다.
    Page<Product> products = prodcutJPARepository.findAllByOrderBySalesDesc(PageRequest.of(page, 5));

    List<ProductResponse.ProductSummary> productSummaryList = products.stream()
            .map(product -> {
                double averageStarCount = reviewJPARepository.findByProduct(product).stream()
                        .mapToInt(Review::getStarCount)
                        .average()
                        .orElse(0);
                Option option = optionJPARepository.findTopByProductOrderByOptionPriceAsc(product).orElseThrow();
                return new ProductResponse.ProductSummary(product, Math.round(averageStarCount * 10) / 10.0, option);
            })
            .collect(Collectors.toList());

    return new bestProductDTO(productSummaryList);
}

}