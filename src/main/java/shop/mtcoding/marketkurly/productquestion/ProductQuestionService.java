package shop.mtcoding.marketkurly.productquestion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception404;
import shop.mtcoding.marketkurly.product.ProdcutJPARepository;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.productquestion.ProductQuestionRequest.ProductQuestionSaveDTO;
import shop.mtcoding.marketkurly.productquestion.ProductQuestionResponse.ProductQuestionMainDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductQuestionService {

        private final ProdcutJPARepository productJPARepository;
        private final ProductQuestionJPARepository productQuestionJPARepository;

        public ProductQuestionMainDTO 상품문의메인() {
                Optional<Product> productOP = productJPARepository.findById(1);
                Product product = productOP.orElseThrow(() -> new Exception404("옵션값을 찾을수 없습니다."));
                List<ProductQuestion> productQuestions = prodcutQuestionJPARepository.findByProductId(1);

                return new ProductQuestionResponse.ProductQuestionMainDTO(product, productQuestions);
        }

        public ProductQuestionSaveDTO 상품문의작성(ProductQuestionSaveDTO productQuestionSaveDTO) {
                // TODO 원본 코드 << 테스트후 바꿔놓기
                // Optional<Product> productOP =
                // productJPARepository.findById(productQuestionSaveDTO.getProductId());
                Optional<Product> productOP = productJPARepository.findById(1);
                Product product = productOP.orElseThrow(() -> new Exception404("상품을 찾을수 없습니다."));
                ProductQuestion productQuestion = ProductQuestion.builder()
                                .productQuestionTitle(productQuestionSaveDTO.getProductQuestionTitle())
                                .productQuestionContent(productQuestionSaveDTO.getProductQuestionContent())
                                .isSecreted(productQuestionSaveDTO.getIsSecreted())
                                .product(product).build();
                productQuestionJPARepository.save(productQuestion);

                return productQuestionSaveDTO;

        }
}
