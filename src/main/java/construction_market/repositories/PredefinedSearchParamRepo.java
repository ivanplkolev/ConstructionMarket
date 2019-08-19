package construction_market.repositories;

import construction_market.entities.categories.predefined.SearchParameterForPredefinedValuesE;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(exported = false)
public interface PredefinedSearchParamRepo extends Repository<SearchParameterForPredefinedValuesE, Long> {

    SearchParameterForPredefinedValuesE findById(Long id);

    SearchParameterForPredefinedValuesE save(SearchParameterForPredefinedValuesE o);

    List<SearchParameterForPredefinedValuesE> findAll();

}
