package shop.mtcoding.marketkurly.cart;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.product.Product;

public class CartResponse {
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {

        private List<CartProductDTO> cartProducts;
        private Integer totalBeforePrice; // 8400
        private Integer totalDiscountPrice; // -2520
        private Integer deliveryFee;
        private Integer totalPrice; // 5880

        public FindAllDTO(List<Cart> carts) {
            this.cartProducts = carts.stream()
                    .map(CartProductDTO::new)
                    .collect(Collectors.toList());
            this.totalBeforePrice = this.cartProducts.stream()
                    .mapToInt(CartProductDTO::getOriginPrice)
                    .sum();
            this.deliveryFee = 0;
            this.totalPrice = this.cartProducts.stream()
                    .mapToInt(CartProductDTO::getDiscountedPrice)
                    .sum();

            this.totalDiscountPrice = this.totalPrice - this.totalBeforePrice;
        }

        @ToString
        @Setter
        @Getter
        class CartProductDTO {
            private Integer cartId;
            private Integer productId;
            private String productPic;
            private String productName;
            private Integer optionId;
            private String optionName;
            private String sellerName;
            private int originPrice;
            private int discountRate;
            private int discountedPrice;
            private int optionQuantity;

            public CartProductDTO(Cart cart) {
                this.cartId = cart.getId();
                Option option = cart.getOption();
                Product product = option.getProduct();
                this.productId = product.getId();
                this.productPic = product.getProductThumbnail();
                this.productName = product.getProductName();
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.sellerName = product.getSeller().getUsername();
                this.originPrice = option.getOptionPrice() * cart.getOptionQuantity();
                this.discountRate = product.getDiscountRate();
                this.discountedPrice = (option.getOptionPrice() * (100 - product.getDiscountRate()) / 100)
                        * cart.getOptionQuantity();
                this.optionQuantity = cart.getOptionQuantity();
            }
        }
    }

    @ToString
    @Setter
    @Getter
    @NoArgsConstructor
    public static class CartOrderPageDTO {

        private Integer sessionUserid;
        private String username;
        private String userEmail;
        private Boolean isDefaultAddress;
        private Integer addressId;
        private String destination;
        private String destinationDetail;
        private Boolean isExpired;
        private LocalDate couponCreatedAt;
        private LocalDate couponExpiredAt;
        private Integer couponCount;

    }
}
