package shop.mtcoding.marketkurly.review;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review_tb")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reviewTitle;
    private String reviewContent;
    private Integer starCount;

    @CreationTimestamp
    private Timestamp reviewCreatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public Review(Integer id, String reviewTitle, String reviewContent, Integer starCount, Timestamp reviewCreatedAt,
            User user, Product product) {
        this.id = id;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.starCount = starCount;
        this.reviewCreatedAt = reviewCreatedAt;
        this.user = user;
        this.product = product;
    }

    
    
}
