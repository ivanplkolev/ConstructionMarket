package construction_market.repositories;

import construction_market.entities.UserE;
import construction_market.entities.projections.UserWithHisOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = true, excerptProjection = UserWithHisOffers.class)
public interface UserRepo extends JpaRepository<UserE, Long> {

//    UserE save(UserE manager);
//
    UserE findByUserName(String name);

}
