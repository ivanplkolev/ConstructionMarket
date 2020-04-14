package construction_market.entities.categories.value_parameters;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This is simple entity class
 * it represents parameter of the offer
 * they can be many different types
 * and they are runtime created
 */
@Data
@Entity
public class OfferParamE {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private SearchParameterE reference;

    int value;


    private OfferParamE() {
    }

    public OfferParamE(SearchParameterE reference,
                       int value) {
        this.reference = reference;
        this.value = value;
    }
}
