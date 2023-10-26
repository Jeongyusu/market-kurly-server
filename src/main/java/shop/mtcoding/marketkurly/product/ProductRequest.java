package shop.mtcoding.marketkurly.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductRequest {
    @Getter
    @NoArgsConstructor
    public static class ProductMainDTO {
        String productThumnail;
        String sellerName;
        String productName;
        String originPrice;
        Integer discountRate;
        Integer discountedPrice;
        Integer averageStarCount;
    }

}
