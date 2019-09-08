package construction_market.entities.projections;


import construction_market.entities.OfferE;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "limitedOffer", types = {OfferE.class})
public interface LimitedOffer {

    long getId();

    String getTitle();

    String getDescription();

    String getPhoneNumber();

    String[] getImages();

    boolean getDeleted();
}
