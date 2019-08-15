package construction_market.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

//import lombok.Data;
//import lombok.ToString;
//@Data
//@ToString(exclude = "password")

@Data
@Entity
public class UserE {


    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private
    @Id
    @GeneratedValue
    Long id;

    private String userName;

    private
    @JsonIgnore
    String password;

    private String[] roles;

    private
    @Version
    @JsonIgnore
    Long version;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OfferE> offerEList;


    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    protected UserE() {
    }

    public UserE(String name,
                 String password,
                 String firstName,
                 String lastName,
                 String email,
                 List<OfferE> offerEList,
                 String... roles) {

        this.userName = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.setPassword(password);
        this.offerEList = offerEList;
        this.roles = roles;
    }
}
