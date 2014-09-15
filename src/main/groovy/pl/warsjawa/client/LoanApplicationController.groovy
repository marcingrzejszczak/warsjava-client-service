package pl.warsjawa.client
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.POST
import static pl.warsjawa.client.ClientServiceApi.*

@CompileStatic
@Slf4j
@RestController
@RequestMapping(API_URL)
@Api(value = "client", description = "Client ")
class LoanApplicationController {

    private final ServiceRestClient serviceRestClient

    @Autowired
    LoanApplicationController(ServiceRestClient serviceRestClient) {
        this.serviceRestClient = serviceRestClient
    }

    @RequestMapping(
            value = CLIENT_URL,
            method = POST,
            consumes = APP_API_VERSION_1,
            produces = APP_API_VERSION_1)
    @ApiOperation(value = "Sends a request ",
            notes = "This will asynchronously verify what's the probability of the user to be a fraud and will call LoanApplicationDecisionMaker")
    void checkIfUserIsFraud(@PathVariable @NotNull String loanApplicationId, @RequestBody @NotNull String loanApplicationDetails) {
        log.info("Sending a request to [$Dependencies.REPORTING] to check if the client is a potential fraud")
        serviceRestClient.forService(Dependencies.REPORTING.toString())
                         .put()
                         .onUrl('/clients')
                         .body(loanApplicationDetails)
                         .withHeaders()
                            .contentType(REPORTING_JSON_V1)
                         .andExecuteFor()
                         .ignoringResponse()
    }
}