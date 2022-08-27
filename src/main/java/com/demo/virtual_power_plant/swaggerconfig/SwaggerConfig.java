package com.demo.virtual_power_plant.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter  {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build()
                ;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Virtual Power Plant Api documentation")
                .description("Virtual Power Plant Api documentation for Developers . This documentation contains the detatils of api that performs some operation ")

                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
