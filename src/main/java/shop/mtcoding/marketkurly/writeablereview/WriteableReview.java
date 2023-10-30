package shop.mtcoding.marketkurly.writeablereview;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.user.User;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "writeable_review_tb")
public class WriteableReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public WriteableReview(Integer id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }

}
