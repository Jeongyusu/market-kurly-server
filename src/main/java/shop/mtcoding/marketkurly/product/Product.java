package shop.mtcoding.marketkurly.product;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
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

    // 관리자에의해서 판매승인 되었는가? << 기본값 false
    @Nullable
    private Boolean isAccepted = false;

    private LocalDate productUploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Builder
    public Product(Integer id,
            String productThumbnail,
            String productDetailPic,
            String productName,
            Integer discountRate,
            String productContent,
            LocalDate productUploadedAt,
            Category category,
            Boolean isAccepted,
            User user,
            LocalDate discountExpiredAt) {
        this.id = id;
        this.productThumbnail = productThumbnail;
        this.productDetailPic = productDetailPic;
        this.productName = productName;
        this.productContent = productContent;
        this.discountRate = discountRate;
        this.productUploadedAt = productUploadedAt;
        this.discountExpiredAt = discountExpiredAt;
        this.isAccepted = isAccepted;
        this.category = category;
        this.seller = user;
    }

}
