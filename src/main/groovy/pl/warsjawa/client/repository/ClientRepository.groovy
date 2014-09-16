package pl.warsjawa.client.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import pl.warsjawa.client.domain.Client

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
interface ClientRepository extends MongoRepository<Client, String> {

    @RestResource(path = 'name', rel = 'name')
    List<Client> findByName(@Param("name") String name)

    @RestResource(path = 'lastName', rel = 'lastName')
    List<Client> findByLastName(@Param("lastName") String lastName)

}