package pl.warsjawa.microservice.config
import com.ofg.infrastructure.config.WebAppConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(WebAppConfiguration)
@ComponentScan('pl.warsjawa.client')
class WebApplicationConfiguration {

}
