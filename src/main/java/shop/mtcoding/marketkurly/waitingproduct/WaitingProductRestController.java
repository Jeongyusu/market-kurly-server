package shop.mtcoding.marketkurly.waitingproduct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductRequest.WProductDTO;

@RequiredArgsConstructor
@RestController
public class WaitingProductRestController {

    private final WaitingProductService waitingProductService;

    @PostMapping("/seller/product/submit/save")
    public ResponseEntity<?> 상품승인요청(@ModelAttribute WProductDTO wProductDTO) {

        // TODO userId << sessionUserId로 바꿔야 함
        Integer userId = 7;
        waitingProductService.상품승인요청(wProductDTO, userId);
        return ResponseEntity.ok().body(ApiUtils.success("통신 성공"));
    }

    @PostMapping("/admin/product/waiting/accept/{wProductId}")
    public ResponseEntity<?> 상품승인(@PathVariable Integer wProductId) {

        // TODO userId << sessionUserId로 바꿔야 함
        Integer userId = 7;
        waitingProductService.상품승인(wProductId);
        return ResponseEntity.ok().body(ApiUtils.success(true));
    }

    @PostMapping("/admin/product/waiting/reject/{wProductId}")
    public ResponseEntity<?> 상품거절(@PathVariable Integer wProductId) {

        // TODO userId << sessionUserId로 바꿔야 함
        Integer userId = 7;
        waitingProductService.상품거절(wProductId);
        return ResponseEntity.ok().body(ApiUtils.success(true));
    }

}
