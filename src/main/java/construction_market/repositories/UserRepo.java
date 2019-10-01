package construction_market.repositories;

import construction_market.entities.UserE;
import construction_market.entities.projections.UserWithHisOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(exported = true, excerptProjection = UserWithHisOffers.class)
public interface UserRepo extends JpaRepository<UserE, Long> {

//    UserE save(UserE manager);
//
    UserE findByUserName(@Param("name")String name);

}
