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

public class ProductQuestionRequest {
    @ToString
    @Getter
    @NoArgsConstructor
    public static class ProductQuestionSaveDTO {

        private Integer productId;
        private String productQuestionTitle;
        private String productQuestionContent;
        private Boolean isSecreted;

        public ProductQuestionSaveDTO(Integer productId, String productQuestionTitle, String productQuestionContent,
                Boolean isSecreted) {
            this.productId = productId;
            this.productQuestionTitle = productQuestionTitle;
            this.productQuestionContent = productQuestionContent;
            this.isSecreted = isSecreted;
        }
    }
}