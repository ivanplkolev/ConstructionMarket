package construction_market.controllers;

import construction_market.entities.OfferE;
import construction_market.repositories.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(method = RequestMethod.GET, value = "/api/offersearch")
    public List<OfferE> controllerMethod(@RequestParam Map<String, String> customQuery) {

        String searchInput = customQuery.get("searchInput");
        Long cat = new Long(customQuery.get("cat"));
        Map<Long, Integer> mins = new HashMap<>();
        Map<Long, Integer> maxs = new HashMap<>();

        for (String key : customQuery.keySet()) {
            if (key.startsWith("min_")) {
                mins.put(new Long(key.replace("min_", "")), new Integer(customQuery.get(key)));
            } else if (key.startsWith("max_")) {
                maxs.put(new Long(key.replace("max_", "")), new Integer(customQuery.get(key)));
            }
        }

        OfferSearchSpecification specification = new OfferSearchSpecification(searchInput, cat, mins, maxs);

        return offerRepo.findAll(specification);
    }


}
