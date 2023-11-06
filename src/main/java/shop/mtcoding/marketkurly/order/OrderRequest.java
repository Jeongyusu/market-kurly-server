package shop.mtcoding.marketkurly.order;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderRequest {

    @Getter
    @NoArgsConstructor
    public static class CreateOrderDTO {

        // 주문자 정보 - 휴대폰
        private String ordererTel;
        // 주문 배송지 pk
        private Integer addressId;
        // 사용할 쿠폰 pk
        private Integer userCouponId;
        // 결제 수단
        private String payment;
    }
}
