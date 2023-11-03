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
    private String orderedProductName;
    private String orderedOptionName;
    private Integer orderedOptionQuantity;
    private Integer orderedOptionPrice;
    private Integer orderedDiscountRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Builder
    public OrderedOption(Integer id, Integer orderedOptionQuantity, Integer orderedOptionPrice,
            String orderedProductName, String orderedOptionName,
            Integer orderedDiscountRate, Option option, Order order) {
        this.id = id;
        this.orderedOptionQuantity = orderedOptionQuantity;
        this.orderedProductName = orderedProductName;
        this.orderedOptionName = orderedOptionName;
        this.orderedOptionPrice = orderedOptionPrice;
        this.orderedDiscountRate = orderedDiscountRate;
        this.option = option;
        this.order = order;
    }

}
