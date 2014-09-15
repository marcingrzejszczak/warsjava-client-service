package pl.warsjawa.client.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import pl.warsjawa.client.domain.Client

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findByLastName(@Param("name") String name);

}