package shop.mtcoding.marketkurly.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService ReviewService;

    @GetMapping("/api/test/Reviews")
    public ResponseEntity<?> 상품리뷰메인() {
        log.info("상품리뷰메인 controller 호출");
        ReviewResponse.ReviewMainDTO reviewMainDTO = ReviewService.상품리뷰메인();
        return ResponseEntity.ok().body(ApiUtils.success(reviewMainDTO));
    }

}
