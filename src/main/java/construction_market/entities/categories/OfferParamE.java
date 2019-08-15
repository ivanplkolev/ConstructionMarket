package construction_market.entities.categories;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class OfferParamE {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private SearchParameterE reference;

    @ManyToOne
    private PredefinedValuesE predefinedValuesE;

    long value;


    private OfferParamE() {
    }

    public OfferParamE(SearchParameterE reference, PredefinedValuesE predefinedValuesE, long value) {
        this.reference = reference;
        this.predefinedValuesE = predefinedValuesE;
        this.value = value;
    }
}
