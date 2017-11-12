package br.com.properties.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Marcos Alves
 *
 */
@SpringBootApplication
@ImportResource({ "classpath*:application-context.xml" })
@EnableSwagger2
public class PropertyApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PropertyApplication.class).web(true).run(args);
	}
	
	@SuppressWarnings("unchecked")
	@Bean
    public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(ApiInfo.DEFAULT).select() 
		          .apis(Predicates.and(RequestHandlerSelectors.basePackage("br.com.properties")))
		             .build();
    }

}
