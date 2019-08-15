package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AgreementE {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

//    @ManyToOne
//    private
//    CategoryЕ parent;

    private float totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AgreementDetailE> agreementDetailEList;
//    private List<Float> subPrices= new ArrayList<>();

    private boolean agreed;


    private AgreementE() {
    }

    public AgreementE(boolean agreed,
                      List<AgreementDetailE> agreementDetailEList,
                      float totalPrice
    ) {
//        this.parent = parent;
        this.agreed = agreed;
        this.agreementDetailEList = agreementDetailEList;
        this.totalPrice = totalPrice;
    }


}
