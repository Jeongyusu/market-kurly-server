package shop.mtcoding.marketkurly.coupon;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.coupon.CouponRequest.CouponSaveDTO;
import shop.mtcoding.marketkurly.coupon.CouponResponse.CouponListDTO;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/admin/coupon")
    public String 쿠폰목록(HttpServletRequest request) {
        CouponListDTO dto = couponService.쿠폰목록();
        request.setAttribute("eCouponListDTOs", dto.getECouponListDTOs());
        request.setAttribute("couponListDTOs", dto.getCouponListDTOs());
        return "admin/couponList";
    }

    @GetMapping("/admin/coupon/detail/{CouponId}")
    public String 쿠폰상세(@PathVariable Integer CouponId, HttpServletRequest request) {
        Coupon coupon = couponService.쿠폰상세(CouponId);
        request.setAttribute("coupon", coupon);
        return "admin/couponDetail";
    }

    @GetMapping("/admin/coupon/save")
    public String 쿠폰등록페이지() {
        return "admin/couponSave";
    }

    @PostMapping("/admin/coupon/save")
    public String 쿠폰생성(CouponSaveDTO couponSaveDTO) {
        couponService.쿠폰생성(couponSaveDTO);
        return "redirect:/admin/coupon";
    }
}
