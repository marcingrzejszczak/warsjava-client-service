package pl.warsjawa.microservice.config
import com.ofg.infrastructure.config.WebAppConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@Configuration
@Import([WebAppConfiguration, RepositoryRestMvcConfiguration])
class WebApplicationConfiguration {
}
