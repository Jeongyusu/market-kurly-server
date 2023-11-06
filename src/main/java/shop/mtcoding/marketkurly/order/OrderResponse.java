package shop.mtcoding.marketkurly.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class OrderResponse {

    @Getter
    @AllArgsConstructor
    public static class CreateOrderDTO {

        private Integer orderId;
    }
}
