package pl.warsjawa.client.repository

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import pl.warsjawa.client.domain.Client

import static pl.warsjawa.client.ClientServiceApi.REPORTING_API_VERSION_1
import static pl.warsjawa.client.Dependencies.REPORTING

@RepositoryEventHandler(Client)
class ClientEventHandler {

    private final ServiceRestClient serviceRestClient

    ClientEventHandler(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    @HandleAfterCreate void handleAfterCreate(Client client) {
        serviceRestClient.forService(REPORTING.toString())
                .post()
                .onUrl('/clients')
                .body(buildCreateRequestBody(client))
                .withHeaders()
                    .contentType(REPORTING_API_VERSION_1)
                .andExecuteFor()
                .ignoringResponse()
    }

    private String buildCreateRequestBody(Client client) {
        def builder = new groovy.json.JsonBuilder()
        builder {
            firstName client.firstName
            lastName client.lastName
            loanId client.id
        }

        return builder.toString()
    }

}
