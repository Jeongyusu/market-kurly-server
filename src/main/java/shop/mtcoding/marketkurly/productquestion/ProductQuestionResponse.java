package shop.mtcoding.marketkurly.productquestion;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.lang.Nullable;

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

        private Integer productId;
        private String productName;
        private List<ProductQuestionDTO> productQuestionDTOs;

        public ProductQuestionMainDTO(Product product, List<ProductQuestion> productQuestions) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productQuestionDTOs = productQuestions.stream().map(t -> new ProductQuestionDTO(t))
                    .collect(Collectors.toList());
        }

        @ToString
        @Getter
        @NoArgsConstructor
        public class ProductQuestionDTO {

            private Integer productQuestionId;
            private String productQuestionTitle;
            private String productQuestionContent;
            private Boolean isAnswered;
            private Boolean isSecreted;
            private String userName;
            private String pReplyContent;
            private Timestamp productQuestionCreatedAt;

            public ProductQuestionDTO(ProductQuestion productQuestion) {
                this.productQuestionId = productQuestion.getId();
                this.productQuestionTitle = productQuestion.getProductQuestionTitle();
                this.productQuestionContent = productQuestion.getProductQuestionContent();
                this.isAnswered = productQuestion.getIsAnswered();
                this.isSecreted = productQuestion.getIsSecreted();
                this.userName = productQuestion.getUser().getUsername();
                if (productQuestion.getProductReply() != null) {
                    this.pReplyContent = productQuestion.getProductReply().getPReplyContent();
                }
                if (productQuestion.getProductReply() == null) {
                    this.pReplyContent = null;
                }
                this.productQuestionCreatedAt = productQuestion.getProductQuestionCreatedAt();
            }
        }
    }
}