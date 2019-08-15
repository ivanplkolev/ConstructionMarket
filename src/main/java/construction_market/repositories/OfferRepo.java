package construction_market.repositories;

import construction_market.entities.OfferE;
import construction_market.entities.projections.LimitedOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = true, excerptProjection = LimitedOffer.class)
public interface OfferRepo extends JpaRepository<OfferE, Long> {

    //    UserE save(UserE manager);
//
    OfferE findByTitle(String title);

}
