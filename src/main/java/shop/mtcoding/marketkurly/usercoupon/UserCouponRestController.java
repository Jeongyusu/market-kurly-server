package shop.mtcoding.marketkurly.usercoupon;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.usercoupon.UserCouponResponse.UserCouponListDTO;

@RequiredArgsConstructor
@RestController
public class UserCouponRestController {

    private final UserCouponService userCouponService;

    @GetMapping("/api/users/coupon")
    public ResponseEntity<?> 쿠폰조회() {

        // TODO SessionUserId << sessionUserId로 바꿔야 함
        Integer SessionUserId = 1;
        UserCouponListDTO dto = userCouponService.쿠폰조회(SessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(dto));
    }

}
