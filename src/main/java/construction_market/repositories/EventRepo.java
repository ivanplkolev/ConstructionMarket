package construction_market.repositories;

import construction_market.entities.EventE;
import construction_market.entities.UserE;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(exported = true)
public interface EventRepo extends Repository<EventE, Long> {

    EventE findByTitle(@Param("title") String title);

    List<EventE> findByClient(UserE client);

    EventE findById(Long id);

    //    @Override
//    @PreAuthorize("#offer?.manager == null or #offer?.manager?.name == authentication?.name")
    EventE save(@Param("event") EventE event);

    //    @Override
//    @PreAuthorize("@offerRepo.findById(#id)?.manager?.name == authentication?.name")
    void deleteById(@Param("id") Long id);

    //    @Override
//    @PreAuthorize("#employee?.manager?.name == authentication?.name")
    void delete(@Param("event") EventE event);

}
