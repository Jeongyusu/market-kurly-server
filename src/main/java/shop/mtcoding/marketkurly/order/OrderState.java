package shop.mtcoding.marketkurly.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderState {

    PENDING("주문완료"),
    SHIPPING("배송중"),
    SHIP_COMPLETE("배송완료"),
    ;

    private final String description;
}
