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
import shop.mtcoding.marketkurly.orderedoption.OrderOptionJAPRepository;
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
    private final OrderOptionJAPRepository orderOptionJAPRepository;

    // page: 0, 1, 2
    public ProductResponse.ProductListDTO 컬리추천(int page) {
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

        return new ProductResponse.ProductListDTO((int) prodcutJPARepository.count(), productSummaryList);

    }

    public ProductResponse.ProductListDTO 신상품(int page) {
        // 한 달 전의 날짜 계산
        LocalDate oneMonthAgo = LocalDate.now().minusDays(30);

        // 한 달 이내의 상품만 가져오도록 쿼리 작성
        Page<Product> products = prodcutJPARepository.findByProductUploadedAtBetween(oneMonthAgo, LocalDate.now(), PageRequest.of(page, 5));

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

        return new ProductResponse.ProductListDTO(prodcutJPARepository.countByProductUploadedAtBetween(oneMonthAgo, LocalDate.now()), productSummaryList);
    }


    public ProductResponse.ProductListDTO 베스트(int page) {
        // 판매량순
        Page<Product> products = orderOptionJAPRepository.findBestProducts(PageRequest.of(page, 5));

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


        Long count = products.getTotalElements();
        return new ProductResponse.ProductListDTO((int)(count == null ? 0 : count), productSummaryList);

    }

    public ProductResponse.ProductListDTO 마감세일(int page, Integer categoryId) {
        Page<Product> products = prodcutJPARepository.findByCategory_Id(categoryId, PageRequest.of(page, 5));

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


        int count = prodcutJPARepository.countByCategory_Id(categoryId);
        return new ProductResponse.ProductListDTO(count, productSummaryList);

    }
}