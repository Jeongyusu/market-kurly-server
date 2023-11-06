package shop.mtcoding.marketkurly.usercoupon;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.marketkurly._core.errors.exception.Exception401;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly._core.utils.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/me/coupons")
public class UserCouponController {

    private final UserCouponService userCouponService;

    @GetMapping
    public ResponseEntity<?> 내쿠폰목록조회(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            throw new Exception401("인증되지 않은 회원입니다");
        }
        String token = authorizationHeader.substring("Bearer ".length());
        Integer userPk = JwtTokenUtils.verify(token).getClaim("id").as(Integer.class);
        return ResponseEntity.ok().body(ApiUtils.success(userCouponService.내쿠폰목록조회(userPk)));
    }
}
