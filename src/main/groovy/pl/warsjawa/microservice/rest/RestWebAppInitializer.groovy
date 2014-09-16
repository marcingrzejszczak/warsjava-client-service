package pl.warsjawa.microservice.rest

import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

import javax.servlet.Filter

class RestWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return [RepositoryRestMvcConfiguration, RestConfiguration, CustomSwaggerConfiguration]
    }

    @Override
    protected String[] getServletMappings() {
        return ["/rest/*"]
    }

    @Override
    protected Filter[] getServletFilters() {
        return null
    }

    @Override
    protected String getServletName() {
        return "rest-exporter"
    }
}