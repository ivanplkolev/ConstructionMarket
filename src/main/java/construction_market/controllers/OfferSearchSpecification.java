package construction_market.controllers;

import construction_market.entities.OfferE;
import construction_market.entities.categories.CategoryE;
import construction_market.entities.categories.predefined.PredefinedOfferParamE;
import construction_market.entities.categories.value_parameters.OfferParamE;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is specification class
 * it is used for seraching offers in the database
 */
public class OfferSearchSpecification implements Specification<OfferE> {

    private String searchInput;
    private Long cat;
    private Map<Long, Integer> mins;
    private Map<Long, Integer> maxs;
    private Map<Long, Long> peredefinedVals;


    public OfferSearchSpecification(String searchInput,
                                    Long cat,
                                    Map<Long, Integer> mins,
                                    Map<Long, Integer> maxs,
                                    Map<Long, Long> peredefinedVals) {
        this.searchInput = searchInput;
        this.cat = cat;
        this.mins = mins;
        this.maxs = maxs;
        this.peredefinedVals = peredefinedVals;
    }

    @Override
    public Predicate toPredicate(Root<OfferE> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (searchInput != null && searchInput.length() > 0) {
            predicates.add(cb.like(root.get("title"), "%" + this.searchInput + "%"));
        }

        if (cat != null && cat > 0) {
            Join<OfferE, CategoryE> categoryЕJoin = root.join("categoryЕ");
            predicates.add(cb.equal(categoryЕJoin.<Long>get("id"), this.cat));
        }

        if (mins != null && !mins.isEmpty()) {
            for (Long min : mins.keySet()) {
                Join<OfferE, OfferParamE> offerParamEJoin = root.join("offerParamEList");
                predicates.add(cb.and(cb.equal(offerParamEJoin.<Long>get("reference"), min),
                        cb.greaterThanOrEqualTo(offerParamEJoin.<Integer>get("value"), this.mins.get(min))));
            }
        }

        if (maxs != null && !maxs.isEmpty()) {
            for (Long max : maxs.keySet()) {
                Join<OfferE, OfferParamE> offerParamEJoin = root.join("offerParamEList");
                predicates.add(cb.and(cb.equal(offerParamEJoin.<Long>get("reference"), max),
                        cb.lessThanOrEqualTo(offerParamEJoin.<Integer>get("value"), this.maxs.get(max))));
            }
        }

        if (peredefinedVals != null && !peredefinedVals.isEmpty()) {
            for (Long predefinedSearchId : peredefinedVals.keySet()) {
                Join<OfferE, PredefinedOfferParamE> offerParamEJoin = root.join("predefinedOfferParamEList");
                predicates.add(cb.and(cb.equal(offerParamEJoin.<Long>get("reference"), predefinedSearchId),
                        cb.equal(offerParamEJoin.<Long>get("predefinedValuesE"), this.peredefinedVals.get(predefinedSearchId))));
            }
        }

        return predicates.isEmpty() ? null : cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
