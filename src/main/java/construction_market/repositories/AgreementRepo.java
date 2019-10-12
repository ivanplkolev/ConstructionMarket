//package construction_market.repositories;
//
//
//import construction_market.entities.AgreementE;
//import construction_market.entities.OfferE;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin
//@RepositoryRestResource(exported = true)
//public interface AgreementRepo extends PagingAndSortingRepository<AgreementE, Long> {
//
//    //    UserE save(UserE manager);
////
//    OfferE findByTitle(@Param("title")String title);
//
//
//    //    @Override
////    @PreAuthorize("#offer?.manager == null or #offer?.manager?.name == authentication?.name")
//    OfferE save(@Param("offer") OfferE offer);
//
//    //    @Override
////    @PreAuthorize("@offerRepo.findById(#id)?.manager?.name == authentication?.name")
//    void deleteById(@Param("id") Long id);
//
//    //    @Override
////    @PreAuthorize("#employee?.manager?.name == authentication?.name")
//    void delete(@Param("agree") OfferE offer);
//
//}
//
