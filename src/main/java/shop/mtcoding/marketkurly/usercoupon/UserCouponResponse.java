package shop.mtcoding.marketkurly.usercoupon;

import lombok.Getter;
import shop.mtcoding.marketkurly.coupon.Coupon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserCouponResponse {

    @Getter
    public static class CouponListDTO {

        private int totalCount;
        private List<CouponDetails> coupons = new ArrayList<>();

        public CouponListDTO(List<Coupon> coupons) {
            this.totalCount = coupons.size();
            this.coupons = coupons.stream().map(CouponDetails::new).collect(Collectors.toList());
        }
    }

    public static class CouponDetails {
        private Integer id;
        private Integer couponNumber;
        private String couponName;
        private String couponContent;
        private Integer reduceAmount; // 할인금액
        private Boolean isExpired; // 쿠폰 만료
        private LocalDateTime couponCreatedAt;
        private LocalDateTime couponExpiredAt;

        public CouponDetails(Coupon coupon) {
            this.id = coupon.getId();
            this.couponNumber = coupon.getCouponNumber();
            this.couponName = coupon.getCouponName();
            this.couponContent = coupon.getCouponContent();
            this.reduceAmount = coupon.getReduceAmount();
            this.isExpired = coupon.getIsExpired();
            this.couponCreatedAt = coupon.getCouponCreatedAt().toLocalDateTime();
            this.couponExpiredAt = coupon.getCouponExpiredAt().toLocalDateTime();
        }
    }
}
