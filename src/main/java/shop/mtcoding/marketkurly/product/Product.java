package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.user.User;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productThumbnail;
    @Nullable
    private String productDetailPic; // 상품정보
    private String productName;
    @Nullable
    private String productContent; // 상품설명
    private Integer discountRate;
    @Nullable
    private LocalDate discountExpiredAt; // 할인만료기간
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    private User seller; // 판매자

    private LocalDate productUploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User seller;

    private String productOrigin;
    private String productContent;
    private Integer originPrice;
    private String productDetailImage;

    @Builder
    public Product(String productThumbnail, String productName, Integer discountRate, LocalDate productUploadedAt, Category category, User seller, String productOrigin, String productContent, Integer originPrice, String productDetailImage) {
        this.productThumbnail = productThumbnail;
        this.productDetailPic = productDetailPic;
        this.productName = productName;
        this.productContent = productContent;
        this.discountRate = discountRate;
        this.productUploadedAt = productUploadedAt;
        this.discountExpiredAt = discountExpiredAt;
        this.category = category;
        this.seller = seller;
        this.productOrigin = productOrigin;
        this.productContent = productContent;
        this.originPrice = originPrice;
        this.productDetailImage = productDetailImage;
        this.seller = user;

    }
}
