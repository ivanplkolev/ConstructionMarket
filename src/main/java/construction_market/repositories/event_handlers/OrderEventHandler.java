package construction_market.repositories.event_handlers;

import construction_market.entities.OfferE;
import construction_market.entities.UserE;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(OfferE.class)
public class OrderEventHandler {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public OrderEventHandler(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @HandleAfterCreate
    protected void onAfterCreateIIIvan(OfferE offerE) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        user.getOfferEList().add(offerE);//todo check for NPE
        userRepo.save(user);
    }

}
