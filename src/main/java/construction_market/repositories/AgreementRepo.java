package construction_market.repositories;


import construction_market.entities.AgreementE;
import construction_market.entities.EventE;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This is Spring Data Rest repository
 * it is crossorigin because the fron end is hosted with another application server
 * it is exported to serve data to the UI
 */
@CrossOrigin
@RepositoryRestResource(exported = true)
public interface AgreementRepo extends Repository<AgreementE, Long> {


    AgreementE findByParent(@Param("parent") EventE parent);

    AgreementE findById(@Param("id") Long id);

//    @Query("SELECT a FROM AgreementE a WHERE a.parent in (select p from EventE where p.client = userE.id)")
//    List<AgreementE> findByUser(UserE userE);


    AgreementE save(@Param("agreement") AgreementE agreement);

}

