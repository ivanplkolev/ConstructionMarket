package construction_market.repositories;

import construction_market.entities.categories.CategoryE;
import construction_market.entities.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(exported = true, excerptProjection = CategoryProjection.class)
public interface CategoryRepo extends JpaRepository<CategoryE, Long> {

    //    UserE save(UserE manager);
//
    CategoryProjection findByName(String name);

    @RestResource(path = "findRoot", rel = "type")
    CategoryE findByType(@Param("type") String type);

}
