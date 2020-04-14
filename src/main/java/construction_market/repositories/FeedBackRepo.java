package construction_market.repositories;

import construction_market.entities.AgreementE;
import construction_market.entities.FeedBackE;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This is Spring Data Rest repository
 * it is crossorigin because the fron end is hosted with another application server
 * it is exported to serve data to the UI
 */
@CrossOrigin
@RepositoryRestResource(exported = true)
public interface FeedBackRepo extends Repository<FeedBackE, Long> {

    FeedBackE findById(@Param("id") Long id);

    FeedBackE findByParent(@Param("parent") AgreementE parent);

    FeedBackE save(@Param("feedBack") FeedBackE feedBackE);

}
