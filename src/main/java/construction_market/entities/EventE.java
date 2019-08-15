package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class EventE {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    private LocalDate date;

//    @ManyToOne
//    private
//    OfferE parent;

    @OneToOne(cascade=CascadeType.ALL)
    private AgreementE agreementE;

    @ManyToOne
    private UserE client;

    private EventE() {
    }

    public EventE(LocalDate date, UserE client, AgreementE agreementE) {
        this.date = date;
        this.client = client;
        this.agreementE = agreementE;
    }

}
