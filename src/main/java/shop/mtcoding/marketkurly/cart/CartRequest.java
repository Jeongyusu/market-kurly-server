package shop.mtcoding.marketkurly.cart;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.coupon.Coupon;

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
    @Setter
    @Getter
    public static class SelectedCartListDTO {
    }
}
