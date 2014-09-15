package pl.warsjawa.microservice.config
import com.ofg.infrastructure.config.WebAppConfiguration
import org.springframework.boot.context.embedded.ServletContextInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

import javax.servlet.ServletContext
import javax.servlet.ServletException

@Configuration
@Import([WebAppConfiguration])
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
