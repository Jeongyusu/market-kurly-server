package shop.mtcoding.marketkurly.cart;

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
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.user.User;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart_tb")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer optionQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Option option;

    @Builder
    public Cart(Integer id, Integer optionQuantity, User user, Option option) {
        this.id = id;
        this.optionQuantity = optionQuantity;
        this.user = user;
        this.option = option;
    }

}
