package construction_market.entities.categories;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SearchParameterE {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade= CascadeType.ALL)
    private List<PredefinedValuesE> predefinedValuesEList;


    private SearchParameterE() {
    }

    public SearchParameterE(String name, List<PredefinedValuesE> predefinedValuesEList) {
        this.name = name;
        this.predefinedValuesEList = predefinedValuesEList;
    }
}
