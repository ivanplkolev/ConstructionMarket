package construction_market.entities.categories.value_parameters;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This is simple entity class
 * it represents simple search param
 */
@Data
@Entity
public class SearchParameterE {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private SearchParameterE() {}

    public SearchParameterE(String name) {
        this.name = name;
    }
}