package shop.mtcoding.marketkurly.coupon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.coupon.CouponRequest.CouponSaveDTO.CouponRegisterDTO;
import shop.mtcoding.marketkurly.usercoupon.UserCoupon;

@RestController
@RequiredArgsConstructor
public class CouponRestController {

    private final CouponService couponService;

    @PostMapping("/api/users/coupon/register")
    public ResponseEntity<?> 쿠폰등록(@RequestBody CouponRegisterDTO couponRegisterDTO) {

        Integer sessionUserId = 2; // TODO << 나중에 SessionUserId로 바꿔야함
        UserCoupon userCoupon = couponService.쿠폰등록(couponRegisterDTO, sessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(userCoupon));
    }

}
