package shop.mtcoding.marketkurly.order;

import java.sql.Timestamp;
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
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderNumber;
    private String state;

    @CreationTimestamp
    private Timestamp orderedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @Builder
    public Order(Integer id, Integer orderNumber, String state, Timestamp orderedAt, User user, Address address) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.state = state;
        this.orderedAt = orderedAt;
        this.user = user;
        this.address = address;
    }

    

}
