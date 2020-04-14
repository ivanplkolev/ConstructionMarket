package construction_market.configuration;

import construction_market.entities.AgreementE;
import construction_market.entities.EventE;
import construction_market.entities.OfferE;
import construction_market.entities.categories.CategoryE;
import construction_market.entities.categories.predefined.PredefinedValuesE;
import construction_market.entities.categories.predefined.SearchParameterForPredefinedValuesE;
import construction_market.entities.categories.value_parameters.SearchParameterE;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * This config class is used to return the id-s for the elements,
 * they are used for modification in the front end part
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(CategoryE.class);
        config.exposeIdsFor(SearchParameterE.class);
        config.exposeIdsFor(SearchParameterForPredefinedValuesE.class);
        config.exposeIdsFor(PredefinedValuesE.class);
        config.exposeIdsFor(OfferE.class);
        config.exposeIdsFor(EventE.class);
        config.exposeIdsFor(AgreementE.class);
    }
}
