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

    private String title;
    private LocalDate fromDate;
    private LocalDate toDate;

    @ManyToOne
    private
    OfferE parent;

//    @OneToOne(cascade = CascadeType.ALL)
//    private AgreementE agreementE;

    @ManyToOne
    private UserE client;

    private EventE() {
    }

    public EventE(OfferE parent, LocalDate fromDate, UserE client, LocalDate todate, String title) {
        this.title = title;
        this.parent = parent;
        this.fromDate = fromDate;
        this.toDate = todate;
        this.client = client;
//        this.agreementE = agreementE;
    }

}
