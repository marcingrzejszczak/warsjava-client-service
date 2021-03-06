package pl.warsjawa.client.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import pl.warsjawa.client.domain.Client

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
interface ClientRepository extends MongoRepository<Client, String> {

    @RestResource(path = 'firstName', rel = 'firstName')
    List<Client> findByFirstName(@Param("firstName") String firstName)

    @RestResource(path = 'lastName', rel = 'lastName')
    List<Client> findByLastName(@Param("lastName") String lastName)

}