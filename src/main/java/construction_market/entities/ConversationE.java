package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This is simple entity class
 * it represents in app conversation with messages
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ConversationE {



    @Id
    @GeneratedValue
    private Long id;

    private
    @Version
    @JsonIgnore
    Long version;

    @LastModifiedDate
    private LocalDateTime lastMessageTime;

    @ManyToOne
    private UserE client;

    @OneToMany(cascade=CascadeType.ALL)
    private List<MessageE> messageEList;

    private ConversationE() {
    }

    public ConversationE(UserE client) {
        this.client = client;
//        this.parent = parent;
    }
}
