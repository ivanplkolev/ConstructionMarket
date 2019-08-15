package construction_market.repositories;

import construction_market.entities.categories.CategoryЕ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = true)
public interface CategoryRepo extends JpaRepository<CategoryЕ, Long> {

    //    UserE save(UserE manager);
//
    CategoryЕ findByName(String name);

}
