package shop.mtcoding.marketkurly.product;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productThumbnail;
    private String productName;
    private Integer discountRate;

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
        this.productName = productName;
        this.discountRate = discountRate;
        this.productUploadedAt = productUploadedAt;
        this.category = category;
        this.seller = seller;
        this.productOrigin = productOrigin;
        this.productContent = productContent;
        this.originPrice = originPrice;
        this.productDetailImage = productDetailImage;
    }
}
