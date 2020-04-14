package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * This is simple entity class
 * it represents feedback for some offer
 */
@Data
@Entity
public class FeedBackE {


    @Id
    @GeneratedValue
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @OneToOne
    private AgreementE parent;

    private int stars;

    private String textReview;


    public FeedBackE(AgreementE parent, int stars, String textReview) {
        this.parent = parent;
        this.stars = stars;
        this.textReview = textReview;
    }
}
