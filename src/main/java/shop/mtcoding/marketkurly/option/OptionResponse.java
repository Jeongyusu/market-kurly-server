package shop.mtcoding.marketkurly.option;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.marketkurly.notice.Notice;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.reviewpic.ReviewPic;
import shop.mtcoding.marketkurly.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

public class OptionResponse {

    @ToString
    @Getter
    @NoArgsConstructor
    public static class OptionSelectMainDTO {

        private Integer productId;
        private String productSellerName;
        private Integer productSellerId;
        private String productName;
        private List<OptionMainDTO> optionMainDTOs;

        public OptionSelectMainDTO(List<Option> options) {
            this.productId = options.get(0).getProduct().getId();
            this.productSellerId = options.get(0).getProduct().getSeller().getId();
            this.productSellerName = options.get(0).getProduct().getSeller().getUsername();
            this.optionMainDTOs = options.stream()
                    .map(option -> new OptionMainDTO(productSellerName, option))
                    .collect(Collectors.toList());
        }

        @ToString
        @Getter
        @NoArgsConstructor
        public class OptionMainDTO {

            private Integer optionId;
            private String productSellerName;
            private String optionName;
            private Integer optionPrice;

            public OptionMainDTO(String productSellerName, Option option) {
                this.optionId = option.getId();
                this.productSellerName = productSellerName;
                this.optionName = option.getOptionName();
                this.optionPrice = option.getOptionPrice();
            }
        }
    }
}