package construction_market.entities.projections;


import construction_market.entities.OfferE;
import construction_market.entities.UserE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "userWithHisOffers", types = {UserE.class})
public interface UserWithHisOffers {

    long getId();

    OfferE getOfferEList();

    @Value("#{@eventRepo.findByClient(target)}")
    List<EventWithAgreements> getEventsList();

//    @Value("#{@agreementRepo.findByClient(target)}")
//    List<EventWithAgreements> getAgreementsList();

    String getEmail();
    String getLastName();
    String getFirstName();

    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();

}
