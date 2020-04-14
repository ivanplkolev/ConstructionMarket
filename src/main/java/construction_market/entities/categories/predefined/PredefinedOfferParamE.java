package construction_market.entities.categories.predefined;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This is simple entity class
 * it represents predefined parameter, it has predefined values,
 * like enumeration, byt runtime defined
 */
@Data
@Entity
public class PredefinedOfferParamE {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private SearchParameterForPredefinedValuesE reference;

    @ManyToOne
    private PredefinedValuesE predefinedValuesE;

    private PredefinedOfferParamE() {
    }

    public PredefinedOfferParamE(SearchParameterForPredefinedValuesE reference,
                                 PredefinedValuesE predefinedValuesE) {
        this.reference = reference;
        this.predefinedValuesE = predefinedValuesE;
    }
}
