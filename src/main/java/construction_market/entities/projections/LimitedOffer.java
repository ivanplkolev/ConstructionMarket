package construction_market.entities.projections;


import construction_market.entities.OfferE;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "limitedOffer", types = {OfferE.class})
public interface LimitedOffer {

    long getId();

    String getTitle();

    String getDescription();

    String getPhoneNumber();

    String[] getImages();

    List getCategoryE();
//    List getOfferParamEList();
//    List getPredefinedOfferParamEList();

    boolean getDeleted();
}
