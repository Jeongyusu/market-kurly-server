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
    @JoinColumn(name = "user_id")
    private User seller; // 판매자

    private LocalDate productUploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String productOrigin;
    private Integer originPrice;
    private String productDetailImage;

    @Builder
    public Product(Integer id, String productThumbnail, String productDetailPic, String productName,
            String productContent, Integer discountRate, LocalDate discountExpiredAt, User seller,
            LocalDate productUploadedAt, Category category, String productOrigin, Integer originPrice,
            String productDetailImage) {
        this.id = id;
        this.productThumbnail = productThumbnail;
        this.productDetailPic = productDetailPic;
        this.productName = productName;
        this.productContent = productContent;
        this.discountRate = discountRate;
        this.discountExpiredAt = discountExpiredAt;
        this.seller = seller;
        this.productUploadedAt = productUploadedAt;
        this.category = category;
        this.productOrigin = productOrigin;
        this.originPrice = originPrice;
        this.productDetailImage = productDetailImage;
    }

}
