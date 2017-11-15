package br.com.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

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
}
