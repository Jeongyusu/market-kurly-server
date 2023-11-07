package shop.mtcoding.marketkurly.orderedoption;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderedOptionResponse {

    @ToString
    @Getter
    @NoArgsConstructor
    public static class OrderedOptionListMainDTO {

        private Integer orderId;
        private String orderNumber;
        private List<OrderedOptionMainDTO> orderedOptionMainDTOs;

        private Integer totalPrice;
        private Integer deliveryFee;
        private Integer finalPrice;

        public OrderedOptionListMainDTO(List<OrderedOption> orderedOptions) {
            this.orderId = orderedOptions.get(0).getOrder().getId();
            this.orderNumber = orderedOptions.get(0).getOrder().getOrderNumber();

            this.orderedOptionMainDTOs = orderedOptions.stream()
                    .map(t -> new OrderedOptionMainDTO(t.getOrder().getState(), t))
                    .collect(Collectors.toList());
            this.totalPrice = orderedOptions.stream()
                    .mapToInt(t -> t.getOrderedOptionPrice() * t.getOrderedOptionQuantity()).sum();
            this.deliveryFee = orderedOptions.get(0).getOrder().getDeliveryFee();
            this.finalPrice = (orderedOptions.stream()
                    .mapToInt(t -> t.getOrderedOptionPrice()
                            * t.getOrderedOptionQuantity() * (100 - t.getOrderedDiscountRate()) / 100)
                    .sum()) - deliveryFee;
            ;
        }

        @ToString
        @Getter
        @NoArgsConstructor
        public class OrderedOptionMainDTO {
            private Integer orderedOptionID;
            private String orderedProductThumbnail;
            private String orderedProductSellerName;
            private String orderedOptionName;
            private Integer orderedOptionQuantity;
            private Integer orderedOptionPrice;
            private Integer discountedPrice;
            private String state;

            public OrderedOptionMainDTO(String state, OrderedOption orderedOption) {
                this.orderedOptionID = orderedOption.getId();
                this.orderedProductThumbnail = orderedOption.getOrderedProductThumbnail();
                this.orderedProductSellerName = orderedOption.getOrderedProductSellerName();
                this.orderedOptionName = orderedOption.getOrderedOptionName();
                this.orderedOptionQuantity = orderedOption.getOrderedOptionQuantity();
                this.orderedOptionPrice = orderedOption.getOrderedOptionPrice();
                this.discountedPrice = orderedOption
                        .getOrderedOptionPrice() * (100 - orderedOption.getOrderedDiscountRate()) / 100;
                this.state = state;
            }

        }
    }

}
