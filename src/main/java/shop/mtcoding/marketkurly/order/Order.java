package shop.mtcoding.marketkurly.order;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.cart.Cart;
import shop.mtcoding.marketkurly.coupon.Coupon;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.orderedoption.OrderedOption;
import shop.mtcoding.marketkurly.user.User;
import shop.mtcoding.marketkurly.usercoupon.UserCoupon;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @CreationTimestamp
    private Timestamp orderedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_coupon_id")
    private UserCoupon userCoupon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderedOption> orderedOptions = new ArrayList<>();

    // 할인 전 총 금액
    private int originTotalPrice;
    // 상품 할인 후 총 금액
    private int discountedTotalPrice;
    // 쿠폰 적용 후 전체 총 금액
    private int finalPrice;

    private String ordererTel;
    private String payment;

    public Order(User user, Address address, List<Cart> carts, String ordererTel, UserCoupon userCoupon, String payment) {
        this.state = OrderState.PENDING;
        this.user = user;
        this.address = address;
        this.orderedAt = Timestamp.from(Instant.now());
        this.ordererTel = ordererTel;
        this.userCoupon = userCoupon;
        this.payment = payment;
        this.orderedOptions = carts.stream()
                .map(cart -> new OrderedOption(cart.getOptionQuantity(), cart.getOption(), this))
                .collect(Collectors.toList());

        this.originTotalPrice = this.orderedOptions.stream()
                .mapToInt(o -> o.getOrderedOptionQuantity() * o.getOption().getOptionPrice())
                .sum();
        this.discountedTotalPrice = this.orderedOptions.stream()
                .mapToInt(o -> (o.getOption().getOptionPrice() * (100 - o.getOption().getProduct().getDiscountRate()) / 100) * o.getOrderedOptionQuantity())
                .sum();
        this.finalPrice = discountedTotalPrice - userCoupon.getCoupon().getReduceAmount();
    }

    public void addOrderedOption(Option option, Integer quantity) {
        this.orderedOptions.add(new OrderedOption(quantity, option, this));
    }

    public void addCartOptions(List<Cart> carts) {
        this.orderedOptions = carts.stream()
                .map(cart -> new OrderedOption(cart.getOptionQuantity(), cart.getOption(), this))
                .collect(Collectors.toList());
    }
}
