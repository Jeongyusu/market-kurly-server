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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.category.Category;

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


    private LocalDate  productUploadedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Builder
    public Product(Integer id, String productThumbnail, String productName, Integer discountRate,
            LocalDate productUploadedAt, Category category) {
        this.id = id;
        this.productThumbnail = productThumbnail;
        this.productName = productName;
        this.discountRate = discountRate;
        this.productUploadedAt = productUploadedAt;
        this.category = category;
    }
    
}
