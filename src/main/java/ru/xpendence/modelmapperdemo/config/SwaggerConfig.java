package ru.xpendence.modelmapperdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Set;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "app.swagger.exposeAPI", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Set.of(MediaType.APPLICATION_JSON_VALUE))
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.xpendence.modelmapperdemo"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Demo",
                "Demo REST API.",
                "1.0",
                null,
                null,
                null, null, Collections.emptyList());
    }


}