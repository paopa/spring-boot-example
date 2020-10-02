package per.pao.example.configuration.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static per.pao.example.configuration.swagger.SwaggerBaseContent.*;

/**
 * url: http://localhost:8080/swagger-ui/index.html
 */
@Configuration("SwaggerConfiguration")
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .contact(generateContact())
                .version(VERSION)
                .build();
    }

    private Contact generateContact() {
        return new Contact(NAME, WEB, EMAIL);
    }
}

class SwaggerBaseContent {
    final static String TITLE = "spring-boot-example";
    final static String VERSION = "0.1";
    final static String NAME = "pao.s";
    final static String WEB = "https://medium.com/@pao.pa";
    final static String EMAIL = "david840422@gmail.com";
    final static String DESCRIPTION = "this is a test project";
}
