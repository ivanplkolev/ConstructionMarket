package construction_market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MessageE {


    @Id
    @GeneratedValue
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @CreatedDate
    private LocalDateTime time;

    private String content;

//    @ManyToOne
//    private
//    ConversationE parent;

    private boolean read;

    private boolean clientMessage;

    private MessageE() {
    }

    public MessageE(String content,LocalDateTime time, boolean clientMessage, boolean read ) {
        this.time = time;
//        this.parent = parent;
        this.read = read;
        this.clientMessage = clientMessage;
        this.content = content;
    }
}
