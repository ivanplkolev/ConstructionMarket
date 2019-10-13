package construction_market.repositories;

import construction_market.entities.AgreementE;
import construction_market.entities.FeedBackE;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by x on 13.10.2019 г..
 */


@CrossOrigin
@RepositoryRestResource(exported = true)
public interface FeedBackRepo extends Repository<AgreementE, Long> {

    FeedBackE findById(@Param("id") Long id);

    FeedBackE findByParent(@Param("parent") AgreementE parent);

    FeedBackE save(@Param("feedBack") FeedBackE feedBackE);

}
