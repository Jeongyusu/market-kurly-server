package shop.mtcoding.marketkurly.productquestion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception404;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.option.OptionJPARepository;
import shop.mtcoding.marketkurly.productquestion.ProductQuestionResponse.ProductQuestionMainDTO;

@Service
@RequiredArgsConstructor
public class ProductQuestionService {

    private final OptionJPARepository optionJPARepository;
    private final ProdcutQuestionJPARepository prodcutQuestionJPARepository;

    public ProductQuestionMainDTO 상품문의메인() {
        Optional<Option> optionOP = optionJPARepository.findById(1);
        Option option = optionOP.orElseThrow(() -> new Exception404("옵션값을 찾을수 없습니다."));
        List<ProductQuestion> productQuestions = prodcutQuestionJPARepository.findByOptionId(1);
        return new ProductQuestionResponse.ProductQuestionMainDTO(option, productQuestions);
    }
}
