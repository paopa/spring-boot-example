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
                .title("spring-boot-example")
                .description(generateDescription())
                .contact(generateContact())
                .version("0.0")
                .build();
    }

    private String generateDescription() {
        return "this is a test project";
    }

    private Contact generateContact() {
        return new Contact("pao.s.w", "https://medium.com/@pao.pa", "david840422@gmail");
    }
}
