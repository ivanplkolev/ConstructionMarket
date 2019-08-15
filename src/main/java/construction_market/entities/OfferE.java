package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import construction_market.entities.categories.CategoryЕ;
import construction_market.entities.categories.OfferParamE;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    private CategoryЕ categoryЕ;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OfferParamE> offerParamEList;

    private OfferE() {
    }

    public OfferE(String title, String description, String phoneNumber,
                  List<ConversationE> conversationEList,
                  List<EventE> eventEList,
                  CategoryЕ categoryЕ,
                  List<OfferParamE> offerParamEList) {
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.conversationEList = conversationEList;
        this.eventEList = eventEList;
        this.categoryЕ = categoryЕ;
        this.offerParamEList = offerParamEList;
    }

}
