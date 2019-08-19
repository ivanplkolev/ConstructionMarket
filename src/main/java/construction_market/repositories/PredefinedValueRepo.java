package construction_market.repositories;

import construction_market.entities.categories.predefined.PredefinedValuesE;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(exported = false)
public interface PredefinedValueRepo extends Repository<PredefinedValuesE, Long> {

    PredefinedValuesE findById(Long id);

    PredefinedValuesE save(PredefinedValuesE o);

    List<PredefinedValuesE> findAll();

}
