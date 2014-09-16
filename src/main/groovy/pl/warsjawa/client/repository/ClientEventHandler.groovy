package pl.warsjawa.client.repository
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import groovy.json.JsonBuilder
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterDelete
import org.springframework.data.rest.core.annotation.HandleAfterSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import pl.warsjawa.client.domain.Client

import static pl.warsjawa.client.ClientServiceApi.REPORTING_API_VERSION_1
import static pl.warsjawa.client.Dependencies.REPORTING
import static pl.warsjawa.client.repository.ClientEventHandler.ActionType.*

@RepositoryEventHandler(Client)
class ClientEventHandler {

    private final ServiceRestClient serviceRestClient

    ClientEventHandler(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    @HandleAfterCreate void handleAfterCreate(Client client) {
        updateReportingService(client, CREATE)
    }

    @HandleAfterSave void handleAfterSave(Client client) {
        updateReportingService(client, SAVE)
    }

    @HandleAfterDelete void handleAfterDelete(Client client) {
        updateReportingService(client, DELETE)
    }


    private void updateReportingService(Client client, ActionType actionType) {
        serviceRestClient.forService(REPORTING.toString())
                         .put()
                         .onUrlFromTemplate('/client/{clientId}')
                            .withVariables(client.id)
                         .body(buildBody(client, actionType))
                         .withHeaders()
                            .contentType(REPORTING_API_VERSION_1)
                         .andExecuteFor()
                         .ignoringResponse()
    }

    private String buildBody(Client client, ActionType actionType) {
        return """
               {
                "actionType":"${actionType.toString()}"
                "client":"${new JsonBuilder(client).toPrettyString()}"
               }
               """
    }

    enum ActionType {
        CREATE, SAVE, DELETE
    }
}
