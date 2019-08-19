package construction_market.repositories;

import construction_market.entities.OfferE;
import construction_market.entities.projections.LimitedOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(exported = true, excerptProjection = LimitedOffer.class)
public interface OfferRepo extends JpaRepository<OfferE, Long>, JpaSpecificationExecutor<OfferE> {

    //    UserE save(UserE manager);
//
    OfferE findByTitle(String title);

}
