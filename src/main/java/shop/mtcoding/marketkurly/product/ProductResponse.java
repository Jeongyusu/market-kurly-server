package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.waitingoption.WaitingOption;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionResponse.WOptionListDTO.WaitingOptionDTO;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProduct;

public class ProductResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ProductDetailDTO {
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
            this.originPrice = product.getOptions().stream()
                    .map(Option::getOptionPrice)
                    .min(Integer::compareTo)
                    .orElse(0);
            this.discountedPrice = Math.round(originPrice * (100 - product.getDiscountRate()) / 1000) * 10;
            this.productOrigin = product.getProductOrigin();
            this.productDetailImage = product.getProductDetailPic();
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

    @ToString
    @Getter
    public static class SellerProductListDTO {

        private List<SellerProductDTO> sellerProductDTOs;

        public SellerProductListDTO(List<Product> products) {
            this.sellerProductDTOs = products.stream().map(t -> new SellerProductDTO(t)).collect(Collectors.toList());
        }

        @ToString
        @Getter
        public static class SellerProductDTO {
            private int productId;
            private String productName;
            private String categoryType;
            private Integer discountRate;
            private LocalDate discountExpiredAt;
            private LocalDate productUploadedAt;

            public SellerProductDTO(Product product) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.categoryType = product.getCategory().getCategoryType();
                this.discountExpiredAt = product.getDiscountExpiredAt();
                this.productUploadedAt = product.getProductUploadedAt();
                this.discountRate = product.getDiscountRate();
            }
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class ProductDetailListDTO {

        private Product product;
        private List<OptionDTO> optionDTOs;

        public ProductDetailListDTO(List<Option> Options) {
            this.product = Options.get(0).getProduct();
            this.optionDTOs = Options.stream().map(t -> new OptionDTO(t))
                    .collect(Collectors.toList());
        }

        @ToString
        @Setter
        @Getter
        public static class OptionDTO {
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;
            private Integer optionStack;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getOptionPrice();
                this.optionStack = option.getOptionStack();
            }
        }
    }
}