package shop.mtcoding.marketkurly.productquestion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception404;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.option.OptionJPARepository;
import shop.mtcoding.marketkurly.product.ProdcutJPARepository;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.productquestion.ProductQuestionResponse.ProductQuestionMainDTO;

@Service
@RequiredArgsConstructor
public class ProductQuestionService {

    private final ProdcutJPARepository productJPARepository;
    private final ProdcutQuestionJPARepository prodcutQuestionJPARepository;

    public ProductQuestionMainDTO 상품문의메인() {
        Optional<Product> productOP = productJPARepository.findById(1);
        Product product = productOP.orElseThrow(() -> new Exception404("옵션값을 찾을수 없습니다."));
        List<ProductQuestion> productQuestions = prodcutQuestionJPARepository.findByProductId(1);

        return new ProductQuestionResponse.ProductQuestionMainDTO(product, productQuestions);
    }
}
