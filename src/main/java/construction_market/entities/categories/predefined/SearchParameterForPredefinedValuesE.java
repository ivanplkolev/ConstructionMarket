package construction_market.entities.categories.predefined;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SearchParameterForPredefinedValuesE {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade= CascadeType.ALL)
    private List<PredefinedValuesE> predefinedValuesEList;


    private SearchParameterForPredefinedValuesE() {
    }

    public SearchParameterForPredefinedValuesE(String name, List<PredefinedValuesE> predefinedValuesEList) {
        this.name = name;
        this.predefinedValuesEList = predefinedValuesEList;
    }
}
