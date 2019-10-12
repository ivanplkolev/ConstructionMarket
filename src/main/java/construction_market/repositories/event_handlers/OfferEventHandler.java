package construction_market.repositories.event_handlers;

import construction_market.entities.OfferE;
import construction_market.entities.UserE;
import construction_market.repositories.EventRepo;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(OfferE.class)
public class OfferEventHandler {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    public OfferEventHandler(UserRepo userRepo, EventRepo e) {
        this.userRepo = userRepo;
        this.eventRepo=e;//todo debug only -- remove it when done
    }

    @HandleAfterCreate
    protected void onAfterCreateIIIvan(OfferE offerE) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        user.getOfferEList().add(offerE);//todo check for NPE
        userRepo.save(user);
    }

}
