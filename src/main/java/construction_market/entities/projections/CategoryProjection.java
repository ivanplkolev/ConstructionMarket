package construction_market.entities.projections;

import construction_market.entities.categories.CategoryE;
import construction_market.entities.categories.predefined.SearchParameterForPredefinedValuesE;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * This is projection interface
 * it is used to represent categories with their subcategories like a tree
 */
@Projection(name = "categoryProjection", types = {CategoryE.class})
public interface CategoryProjection {

    long getId();

    String getName();

    List<CategoryProjection> getSubCategories();


    List<SearchparamProjection> getParameters();


    List<SearchParameterForPredefinedValuesE> getPredefinedParameters();
}
