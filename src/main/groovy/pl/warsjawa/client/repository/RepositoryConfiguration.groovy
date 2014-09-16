package pl.warsjawa.client.repository

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryConfiguration {

    @Bean ClientEventHandler clientEventHandler(ServiceRestClient serviceRestClient) {
        return new ClientEventHandler(serviceRestClient)
    }
}
