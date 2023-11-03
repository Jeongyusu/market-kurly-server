package shop.mtcoding.marketkurly.product;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.marketkurly.option.Option;

public class ProductResponse {

    @Getter
    public static class ProductDetailDTO{
        private int productId;
        private String productName;
        private String productContent;
        private Integer discountRate;
        private Integer discountedPrice;
        private Integer originPrice;
        private String productOrigin;
        private String productDetailImage;
        private String seller;

        public ProductDetailDTO(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productContent = product.getProductContent();
            this.discountRate = product.getDiscountRate();
            this.discountedPrice = product.getOriginPrice() * (100 - product.getDiscountRate()) / 100;
            this.originPrice = product.getOriginPrice();
            this.productOrigin = product.getProductOrigin();
            this.productDetailImage = product.getProductDetailImage();
            this.seller = product.getSeller().getUsername();
        }
    }

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