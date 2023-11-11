package shop.mtcoding.marketkurly.writeablereview;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.user.User;
import shop.mtcoding.marketkurly.writeablereview.WriteableReviewResponse.WriteableReviewListDTO;

@RequiredArgsConstructor
@RestController
public class WriteableReviewRestController {

    private final WriteableReviewService writeableReviewService;
    private final HttpSession session;

    @GetMapping("/api/reviews/writeable")
    public ResponseEntity<?> 작성가능리뷰() {

        User user = (User) session.getAttribute("sessionUser");
        System.out.println("작성 가능 리뷰 컨트롤러 호출 sessionUser Id : " + user.getId());
        WriteableReviewListDTO dto = writeableReviewService.작성가능리뷰(user.getId());
        return ResponseEntity.ok().body(ApiUtils.success(dto));

    }

}
