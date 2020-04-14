package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import construction_market.entities.categories.CategoryE;
import construction_market.entities.categories.value_parameters.OfferParamE;
import construction_market.entities.categories.predefined.PredefinedOfferParamE;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * This is simple entity class
 * it represents Offer
 */
@Data
@Entity
public class OfferE {

    private
    @Id
    @GeneratedValue
    Long id;
    private String title;
    private String phoneNumber;
    private String description;
    private String[] images;

    private
    @Version
    @JsonIgnore
    Long version;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ConversationE> conversationEList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EventE> eventEList;

    private boolean deleted = false;

    @ManyToOne
    private CategoryE categoryE;//todo - make it list

    @OneToMany(cascade = CascadeType.ALL)
    private List<OfferParamE> offerParamEList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PredefinedOfferParamE> predefinedOfferParamEList;

    private OfferE() {
    }

    public OfferE(String title, String description, String phoneNumber,
                  List<ConversationE> conversationEList,
                  List<EventE> eventEList,
                  CategoryE categoryE,
                  List<OfferParamE> offerParamEList,
                  List<PredefinedOfferParamE> predefinedOfferParamEList) {
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.conversationEList = conversationEList;
        this.eventEList = eventEList;
        this.categoryE = categoryE;
        this.offerParamEList = offerParamEList;
        this.predefinedOfferParamEList = predefinedOfferParamEList;
    }

}
