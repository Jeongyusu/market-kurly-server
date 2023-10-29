package shop.mtcoding.marketkurly.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.marketkurly.option.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductResponse {

    @ToString
    @Getter
    @NoArgsConstructor
    public static class ProductListDTO {
        private int totalCount;
        List<ProductSummary> result = new ArrayList<>();
        public ProductListDTO(int totalCount, List<ProductSummary> result) {
            this.totalCount = totalCount;
            this.result = result;
        }


    }

    @ToString
    @Getter
    @NoArgsConstructor
    public static class bestProductDTO {
        List<ProductSummary> result = new ArrayList<>();

        public bestProductDTO(List<ProductSummary> result) {
            this.result = result;
        }

    }


    @ToString
    @Getter
    @NoArgsConstructor
    public static class newProductDTO {
        List<ProductSummary> result = new ArrayList<>();

        public newProductDTO(List<ProductSummary> result) {
            this.result = result;
        }
    }

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
        Integer originPrice;
        Integer discountRate;
        Integer discountedPrice;
        Double averageStarCount;

        public ProductSummary(Product product, Double averageStarCount, Option option) {
            this.productId = product.getId();
            this.productThumnail = product.getProductThumbnail();
            this.productName = product.getProductName();
            this.originPrice = option.getOptionPrice();
            this.discountRate = product.getDiscountRate();
            this.discountedPrice = option.getOptionPrice() * (100 - product.getDiscountRate()) / 100;
            this.averageStarCount = averageStarCount;
        }
    }
}