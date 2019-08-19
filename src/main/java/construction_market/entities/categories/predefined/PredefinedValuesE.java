package construction_market.entities.categories.predefined;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PredefinedValuesE {


    @Id
    @GeneratedValue
    private Long id;

    String value;

    private PredefinedValuesE() {
    }

    public PredefinedValuesE(String value) {
        this.value = value;
    }

}
