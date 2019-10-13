package construction_market.controllers;

import construction_market.entities.*;
import construction_market.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private AgreementRepo agreementRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FeedBackRepo feedBackRepo;


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
//        offerRepo.save(event.getParent());//todo -- make it like in the agreement --- it is correct !!!
        event.setParent(offerRepo.findById(event.getParent().getId()));

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        event.setClient(user);
        eventRepo.save(event);

        if (event.getParent().getEventEList() == null) {
            event.getParent().setEventEList(new ArrayList<>());
        }

        event.getParent().getEventEList().add(event);

        offerRepo.save(event.getParent());

        return event;
    }

    @PostMapping("/api/saveHelper/offerEs")
    OfferE saveOfferE(@RequestBody OfferE offer) {
        offerRepo.save(offer);


        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserE user = this.userRepo.findByUserName(name);
        user.getOfferEList().add(offer);//todo check for NPE
        userRepo.save(user);

        return offer;
    }

    @PostMapping("/api/saveHelper/agreementEs")
    AgreementE saveAgreement(@RequestBody AgreementE agreementE) {

        agreementE.setParent(eventRepo.findById(agreementE.getParent().getId()));

        agreementE.setTotalPrice(agreementE
                .getAgreementDetailEList()
                .stream()
                .map(AgreementDetailE::getPrice)
                .reduce(0f, (a, b) -> a + b));

        agreementE = agreementRepo.save(agreementE);

        return agreementE;
    }

    @PostMapping("/api/saveHelper/feedBackEs")
    FeedBackE saveFeedBack(@RequestBody FeedBackE feedBack) {

        feedBack.setParent(agreementRepo.findById(feedBack.getParent().getId()));

        feedBack = feedBackRepo.save(feedBack);

        return feedBack;
    }


}
