package shop.mtcoding.marketkurly.productquestion;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.product.Product;

public class ProductQuestionResponse {
    @ToString
    @Getter
    @NoArgsConstructor
    public static class ProductQuestionMainDTO {

        // TODO optionName쓸지 productName쓸지 결정 (문의 세부페이지 유무에 따라 다름)
        private String productName;
        private List<ProductQuestionDTO> productQuestionDTOs;

        public ProductQuestionMainDTO(Product product, List<ProductQuestion> productQuestions) {
            this.productName = product.getProductName();
            this.productQuestionDTOs = productQuestions.stream().map(t -> new ProductQuestionDTO(t))
                    .collect(Collectors.toList());
        }

        @ToString
        @Getter
        @NoArgsConstructor
        public class ProductQuestionDTO {
            private String productQuestionTitle;
            private Boolean isAnswered;
            private Boolean isSecreted;
            private String userName;
            private String pReplyContent;
            private Timestamp productQuestionCreatedAt;

            public ProductQuestionDTO(ProductQuestion productQuestion) {
                this.productQuestionTitle = productQuestion.getProductQuestionTitle();
                this.isAnswered = productQuestion.getIsAnswered();
                this.isSecreted = productQuestion.getIsSecreted();
                this.userName = productQuestion.getUser().getUsername();
                this.pReplyContent = productQuestion.getProductReply().getPReplyContent();
                this.productQuestionCreatedAt = productQuestion.getProductQuestionCreatedAt();
            }
        }
    }

    public static String ProductQuestionMainDTO(Product product, List<ProductQuestion> productQuestions) {
        return null;
    }
}