package shop.mtcoding.marketkurly.orderedoption;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.order.Order;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ordered_option_tb")
public class OrderedOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderedOptionQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderedOption(Integer orderedOptionQuantity, Option option, Order order) {
        this.orderedOptionQuantity = orderedOptionQuantity;
        this.option = option;
        this.order = order;
    }

}
