package in.priya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import in.priya.binding.Customer;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
	
	 @Override
	    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig,
	      CorsRegistry cors) {
		 
		 HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.DELETE };
		  
		   restConfig.getExposureConfiguration()
		              .forDomainType(Customer.class)
		              .withItemExposure((metadata,http)->http.disable(unsupportedMethods))
		               .withCollectionExposure((metadata,http)->http.disable(unsupportedMethods));
	       
	    }

}
