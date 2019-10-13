package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AgreementE {

    public static final int STATUS_NEW = 1;
    public static final int STATUS_ACCEPTED = 2;
    public static final int STATUS_REJECTED = 3;
    public static final int STATUS_COMPLETED = 4;
    public static final int STATUS_CANCELED = 5;
    public static final int STATUS_DISPUTE = 6;
    public static final int STATUS_DISPUTE_CONFIRMED = 7;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

//    @ManyToOne
//    private
//    CategoryE parent;

    private float totalPrice;

    @OneToOne
    private EventE parent;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AgreementDetailE> agreementDetailEList;
//    private List<Float> subPrices= new ArrayList<>();

    private int status = STATUS_NEW;


    private AgreementE() {
    }

    public AgreementE(int status,
                      List<AgreementDetailE> agreementDetailEList,
                      float totalPrice,
                      EventE parent) {
        this.status = status;
        this.agreementDetailEList = agreementDetailEList;
        this.totalPrice = totalPrice;
        this.parent = parent;
    }


}
