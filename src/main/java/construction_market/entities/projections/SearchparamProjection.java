package construction_market.entities.projections;

import construction_market.entities.categories.value_parameters.SearchParameterE;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by x on 17.8.2019 г..
 */

@Projection(name = "searchparamProjection", types = {SearchParameterE.class})
public interface SearchparamProjection {

    long getId();

    String getName();

}
