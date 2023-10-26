package shop.mtcoding.marketkurly.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {
    @ToString
    @Getter
    @NoArgsConstructor
    public static class ProductMainDTO {
        List<ProductSummary> result = new ArrayList<>();

        public ProductMainDTO(List<ProductSummary> result) {
            this.result = result;
        }
    }

    @ToString
    @Getter
    public static class ProductSummary {
        Integer productId;
        String productThumnail;
        String productName;
        Integer price;
        Integer discountRate;
        Integer discountedPrice;
        Double averageStarCount;

        public ProductSummary(Product product, Double averageStarCount) {
            this.productId = product.getId();
            this.productThumnail = product.getProductThumbnail();
            this.productName = product.getProductName();
            this.price = product.getPrice();
            this.discountRate = product.getDiscountRate();
            this.discountedPrice = product.getPrice() * (100 - product.getDiscountRate()) / 100;
            this.averageStarCount = averageStarCount;
        }
    }
}
