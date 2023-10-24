package shop.mtcoding.marketkurly.productquestion;

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
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.user.User;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_question_tb")
public class ProductQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productQuestionTitle;
    private String productQuestionContent;
    private Boolean isAnswered;
    private Boolean isSecreted;

    @CreationTimestamp
    private Timestamp productQuestionCeatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;


    @Builder
    public ProductQuestion(Integer id, String productQuestionTitle, String productQuestionContent, Boolean isAnswered,
            Boolean isSecreted, Timestamp productQuestionCeatedAt, User user, Option option) {
        this.id = id;
        this.productQuestionTitle = productQuestionTitle;
        this.productQuestionContent = productQuestionContent;
        this.isAnswered = isAnswered;
        this.isSecreted = isSecreted;
        this.productQuestionCeatedAt = productQuestionCeatedAt;
        this.user = user;
        this.option = option;
    }

    
    
}
