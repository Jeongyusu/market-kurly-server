package shop.mtcoding.marketkurly.orderedoption;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.order.Order;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ordered_option_tb")
public class OrderedOption {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderedOptionQuantity;
    private Integer orderedOptionPrice;
    private Integer orderedDiscountRate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Builder
    public OrderedOption(Integer id, Integer orderedOptionQuantity, Integer orderedOptionPrice,
            Integer orderedDiscountRate, Option option, Order order) {
        this.id = id;
        this.orderedOptionQuantity = orderedOptionQuantity;
        this.orderedOptionPrice = orderedOptionPrice;
        this.orderedDiscountRate = orderedDiscountRate;
        this.option = option;
        this.order = order;
    }

    
}
