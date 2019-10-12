package construction_market.controllers;

import construction_market.entities.EventE;
import construction_market.entities.OfferE;
import construction_market.entities.UserE;
import construction_market.repositories.EventRepo;
import construction_market.repositories.OfferRepo;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 17.8.2019 г..
 */

@Controller
@CrossOrigin
public class OffersController {

    @Autowired
    private OfferRepo offerRepo;

    @Autowired
    private EventRepo eventRepo;



    @Autowired
    private UserRepo userRepo;


    @RequestMapping(method = RequestMethod.GET, value = "/api/offersearch")
    public List<OfferE> controllerMethod(@RequestParam Map<String, String> customQuery) {

        String searchInput = customQuery.get("searchInput");
        Long cat = new Long(customQuery.get("cat"));
        Map<Long, Integer> mins = new HashMap<>();
        Map<Long, Integer> maxs = new HashMap<>();
        Map<Long, Long> peredefinedVals = new HashMap<>();

        for (String key : customQuery.keySet()) {
            if (key.startsWith("min_")) {
                mins.put(new Long(key.replace("min_", "")), new Integer(customQuery.get(key)));
            } else if (key.startsWith("max_")) {
                maxs.put(new Long(key.replace("max_", "")), new Integer(customQuery.get(key)));
            } else if (key.startsWith("pre_")) {
                peredefinedVals.put(new Long(key.replace("pre_", "")), new Long(customQuery.get(key)));
            }
        }

        OfferSearchSpecification specification = new OfferSearchSpecification(searchInput, cat, mins, maxs, peredefinedVals);

        return offerRepo.findAll(specification);
    }


    @PostMapping("/api/saveHelper/eventEs")
    EventE saveEventE(@RequestBody EventE event) {
        offerRepo.save(event.getParent());
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        event.setClient(user);
        eventRepo.save(event);

        return event;
    }

    @PostMapping("/api/savehelper/offerEs")
    OfferE saveOfferE(@RequestBody OfferE offer) {
        offerRepo.save(offer);


        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        user.getOfferEList().add(offer);//todo check for NPE
        userRepo.save(user);

        return offer;
    }


}
