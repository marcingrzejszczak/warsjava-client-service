package pl.warsjawa.microservice.config

import com.ofg.infrastructure.discovery.ServiceDiscoveryConfiguration
import com.ofg.infrastructure.healthcheck.HealthCheckConfiguration
import com.ofg.infrastructure.metrics.registry.MetricsConfiguration
import com.ofg.infrastructure.web.config.WebInfrastructureConfiguration
import com.ofg.infrastructure.web.swagger.SwaggerConfiguration
import org.springframework.boot.context.embedded.ServletContextInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import pl.warsjawa.microservice.rest.RestWebAppInitializer

import javax.servlet.ServletContext
import javax.servlet.ServletException

@Configuration
@Import([WebInfrastructureConfiguration, ServiceDiscoveryConfiguration, MetricsConfiguration, HealthCheckConfiguration, SwaggerConfiguration])
class WebApplicationConfiguration {

    @Bean
    ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {

            @Override
            void onStartup(ServletContext servletContext) throws ServletException {
                new RestWebAppInitializer().onStartup(servletContext)
            }
        }
    }
}
