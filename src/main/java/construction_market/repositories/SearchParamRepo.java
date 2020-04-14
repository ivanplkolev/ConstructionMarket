package construction_market.repositories;

import construction_market.entities.categories.value_parameters.SearchParameterE;
import construction_market.entities.projections.SearchparamProjection;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * This is Spring Data Rest repository
 */
@RepositoryRestResource(exported = false, excerptProjection = SearchparamProjection.class)
public interface SearchParamRepo extends Repository<SearchParameterE, Long> {

    SearchParameterE findById(Long id);

    SearchParameterE save(SearchParameterE o);

    List<SearchParameterE> findAll();

}
