package shop.mtcoding.marketkurly.cart;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.cart.CartResponse.FindAllDTO.CartProductDTO;
import shop.mtcoding.marketkurly.coupon.Coupon;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.product.Product;
import java.util.stream.Collectors;

public class CartRequest {

    @ToString
    @Setter
    @Getter
    public static class SelectedCartDTO {

        private Integer selectedAddressId;
        private List<SelectedCartListDTO> selectedCartDTOs;

        public SelectedCartDTO(Integer selectedAddressId, List<SelectedCartListDTO> selectedCartListDTOs) {
            this.selectedAddressId = selectedAddressId;
            this.selectedCartDTOs = selectedCartListDTOs;
        }

    }

    @ToString
    @Getter
    @Setter
    public static class SelectedCartListDTO {

        private List<SelectedCartProductDTO> selectedCartProducts;
        private Integer totalBeforePrice;
        private Integer totalDiscountPrice;
        private Integer deliveryFee;
        private Integer totalPrice;
        private Integer finalPrice;
        private Integer userCouponId;
        private Integer addressId;

        public SelectedCartListDTO(List<SelectedCartProductDTO> selectedCartProducts, Integer totalBeforePrice,
                Integer totalDiscountPrice,
                Integer deliveryFee, Integer totalPrice, Integer finalPrice, Integer userCouponId, Integer addressId) {
            this.selectedCartProducts = selectedCartProducts;
            this.totalBeforePrice = totalBeforePrice;
            this.totalDiscountPrice = totalDiscountPrice;
            this.deliveryFee = deliveryFee;
            this.totalPrice = totalPrice;
            this.finalPrice = finalPrice;
            this.userCouponId = userCouponId;
            this.addressId = addressId;
        }

    }

    @ToString
    @Setter
    @Getter
    public static class SelectedCartProductDTO

    {
        private Integer cartId;
        private Integer productId;
        private String productPic;
        private String productName;
        private Integer optionId;
        private String optionName;
        private String sellerName;
        private Integer totalOptionOriginPrice;
        private Integer totalOptionDiscountedPrice;
        private Integer optionQuantity;

        public SelectedCartProductDTO(Integer cartId, Integer productId, String productPic, String productName,
                Integer optionId, String optionName, String sellerName, Integer totalOptionOriginPrice,
                Integer totalOptionDiscountedPrice, Integer optionQuantity) {
            this.cartId = cartId;
            this.productId = productId;
            this.productPic = productPic;
            this.productName = productName;
            this.optionId = optionId;
            this.optionName = optionName;
            this.sellerName = sellerName;
            this.totalOptionOriginPrice = totalOptionOriginPrice;
            this.totalOptionDiscountedPrice = totalOptionDiscountedPrice;
            this.optionQuantity = optionQuantity;
        }

    }
}
