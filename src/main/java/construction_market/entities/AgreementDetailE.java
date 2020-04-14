package construction_market.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This is simple entity class
 * it represents details for the agreement
 * they are attached to agreement
 */
@Data
@Entity
public class AgreementDetailE {

    @Id
    @GeneratedValue
    private Long id;

    private float price;

    private String description;

    private AgreementDetailE() {
    }

    public AgreementDetailE(String description, float price) {
        this.description = description;
        this.price = price;
    }


}