package shop.mtcoding.marketkurly.coupon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "coupon_tb")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer couponNumber;
    private String couponName;
    private Integer couponContent;
    private Integer reduceAmount;
    private Boolean isExpired;

    @CreationTimestamp
    private Timestamp couponCreatedAt;

    @CreationTimestamp
    private Timestamp couponExpiredAt;

    @Builder
    public Coupon(Integer id, Integer couponNumber, String couponName, Integer couponContent, Integer reduceAmount,
            Boolean isExpired, Timestamp couponCreatedAt, Timestamp couponExpiredAt) {
        this.id = id;
        this.couponNumber = couponNumber;
        this.couponName = couponName;
        this.couponContent = couponContent;
        this.reduceAmount = reduceAmount;
        this.isExpired = isExpired;
        this.couponCreatedAt = couponCreatedAt;
        this.couponExpiredAt = couponExpiredAt;
    }

}
