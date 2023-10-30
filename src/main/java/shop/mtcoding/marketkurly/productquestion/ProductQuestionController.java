package shop.mtcoding.marketkurly.productquestion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductQuestionController {

    private final ProductQuestionService ProductQuestionService;

    @GetMapping("/api/test/ProductQuestionMain")
    public ResponseEntity<?> 상품문의메인() {
        log.info("상품문의메인 controller 호출");
        ProductQuestionResponse.ProductQuestionMainDTO productQuestionMainDTO = ProductQuestionService.상품문의메인();
        return ResponseEntity.ok().body(ApiUtils.success(productQuestionMainDTO));
    }

}
