package shop.mtcoding.marketkurly.coupon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.coupon.CouponRequest.CouponSaveDTO;
import shop.mtcoding.marketkurly.coupon.CouponResponse.CouponListDTO;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CouponService {

    private final CouponJPARepository couponJPARepository;

    public void 쿠폰등록(CouponSaveDTO couponSaveDTO) {

        UUID uuid = UUID.randomUUID();
        String couponNumber = uuid.toString().substring(0, 18);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate couponCreatedAt = LocalDate.parse(couponSaveDTO.getCouponCreatedAt(), formatter);
        LocalDate couponExpiredAt = LocalDate.parse(couponSaveDTO.getCouponExpiredAt(), formatter);

        Coupon coupon = Coupon.builder()
                .couponName(couponSaveDTO.getCouponName())
                .couponNumber(couponNumber)
                .couponContent(couponSaveDTO.getCouponContent())
                .isExpired(couponSaveDTO.getIsExpired())
                .reduceAmount(couponSaveDTO.getReduceAmount())
                .couponCreatedAt(couponCreatedAt)
                .couponExpiredAt(couponExpiredAt).build();

        couponJPARepository.save(coupon);
    }

    public CouponListDTO 쿠폰목록() {
        List<Coupon> coupons = couponJPARepository.findAll();
        return new CouponListDTO(coupons);
    }

}
