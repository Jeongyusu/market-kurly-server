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

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

public class OptionResponse {
    @ToString
    @Getter
    @NoArgsConstructor
    public static class OptionSelectMainDTO {

    }

}