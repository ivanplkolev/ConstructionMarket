package construction_market.entities.categories;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryЕ {

    public static final int TYPE_MACHINES = 1;
    public static final int TYPE_SERVICES = 2;


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade= CascadeType.ALL)
    private List<CategoryЕ> subCategories;

    @ManyToMany
    private List<SearchParameterE> parameters;

    private int type;


    private CategoryЕ() {
    }

    public CategoryЕ(String name, List<CategoryЕ> subCategories, List<SearchParameterE> parameters, int type) {
        this.name = name;
        this.subCategories = subCategories;
        this.parameters = parameters;
        this.type = type;
    }

}
