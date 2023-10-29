package shop.mtcoding.marketkurly.review;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.user.UserRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/api/test/Reviews")
    public ResponseEntity<?> 상품리뷰메인페이지() {
        ReviewResponse.ReviewMainDTO reviewMainDTO = reviewService.상품리뷰메인페이지();
        return ResponseEntity.ok().body(ApiUtils.success(reviewMainDTO));
    }

}
