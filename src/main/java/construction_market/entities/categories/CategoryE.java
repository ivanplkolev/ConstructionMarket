package construction_market.entities.categories;

import construction_market.entities.categories.predefined.SearchParameterForPredefinedValuesE;
import construction_market.entities.categories.value_parameters.SearchParameterE;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * This is simple entity class
 * it represents category of the offer
 */
@Data
@Entity
public class CategoryE {

    public static final String TYPE_SERVICES = "1";
    public static final String TYPE_MACHINES = "2";
    public static final String TYPE_PROJECTS = "3";


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CategoryE> subCategories;

    @ManyToMany
    private List<SearchParameterE> parameters;


    @ManyToMany
    private List<SearchParameterForPredefinedValuesE> predefinedParameters;

    private String type;


    private CategoryE() {
    }

    public CategoryE(String name,
                     List<CategoryE> subCategories,
                     List<SearchParameterE> parameters,
                     String type,
                     List<SearchParameterForPredefinedValuesE> predefinedParameters) {
        this.name = name;
        this.subCategories = subCategories;
        this.parameters = parameters;
        this.predefinedParameters = predefinedParameters;
        this.type = type;
    }

}
