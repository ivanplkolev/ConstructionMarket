package construction_market.repositories.event_handlers;


import construction_market.entities.EventE;
import construction_market.entities.OfferE;
import construction_market.entities.UserE;
import construction_market.repositories.EventRepo;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * This is Event handler
 * some of the methods are added for debug purpose
 */
@Component
@RepositoryEventHandler(OfferE.class)
public class EventEventHandler {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    public EventEventHandler(UserRepo userRepo, EventRepo e) {
        this.userRepo = userRepo;
        this.eventRepo=e;//todo debug only -- remove it when done
    }

    @HandleAfterCreate
    protected void onAfterCreateIIIvan(EventE event) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
//        user.getOfferEList().add(event);//todo check for NPE
//        userRepo.save(user);
    }

    @HandleBeforeCreate
    protected void onAfterCreateIIIvan2(EventE event) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
//        user.getOfferEList().add(event);//todo check for NPE
//        userRepo.save(user);
    }

    @HandleBeforeSave
    protected void onAfterCreateIIIvan3(EventE event) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
//        user.getOfferEList().add(event);//todo check for NPE
//        userRepo.save(user);
    }

}

