package construction_market.entities.projections;

import construction_market.entities.categories.value_parameters.SearchParameterE;
import org.springframework.data.rest.core.config.Projection;

/**
 * This is projection interface
 * it is used to represent search param with its id and name
 */
@Projection(name = "searchparamProjection", types = {SearchParameterE.class})
public interface SearchparamProjection {

    long getId();

    String getName();

}
