package construction_market.entities.projections;

import construction_market.entities.AgreementE;
import construction_market.entities.EventE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

/**
 * This is projection interface
 * it is used to represent events with their agreements if exists
 */
@Projection(name = "eventWithAgreements", types = {EventE.class})
public interface EventWithAgreements {


    long getId();

    @Value("#{@agreementRepo.findByParent(target)}")
    AgreementE getAgreement();

    String getTitle();

    LocalDate getFromDate();

    LocalDate getToDate();

//    UserE getClient();
}
