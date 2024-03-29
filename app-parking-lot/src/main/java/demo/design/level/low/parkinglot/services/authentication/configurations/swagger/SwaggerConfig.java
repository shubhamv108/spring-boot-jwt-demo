package demo.design.level.low.parkinglot.services.authentication.configurations.swagger;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
//@EnableSwagger2
//@Profile(value= {"dev", "qa", "stage", "prod"})
public class SwaggerConfig implements WebMvcConfigurer {

    @Autowired
    private SwaggerConfigs config;

//    @Bean
//    public Docket api() {
//        ParameterBuilder jtiParamBuilder = new ParameterBuilder();
//        ParameterBuilder authorizationParamBuilder = new ParameterBuilder();
//        ParameterBuilder utidParamBuilder = new ParameterBuilder();
//        jtiParamBuilder.name(config.getHeaders().getJti()).modelRef(new ModelRef("string")).parameterType("header").required(false);
//        authorizationParamBuilder.name(config.getHeaders().getAuthorization()).modelRef(new ModelRef("string")).parameterType("header")
//                .required(false);
//        utidParamBuilder.name(config.getHeaders().getUti()).modelRef(new ModelRef("string")).parameterType("header").required(false);
//        List<Parameter> aParameters = new ArrayList<>();
//        aParameters.add(jtiParamBuilder.build());
//        aParameters.add(authorizationParamBuilder.build());
//        aParameters.add(utidParamBuilder.build());
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(config.getBase()))
//                .paths(regex(config.getRegex())).build().globalOperationParameters(aParameters).apiInfo(apiInfo());
//    }

    @Bean
    public Docket api() {
        return null;/*new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(paths()).build().apiInfo(apiInfo());*/
    }

    private Predicate<String> paths() {
        return null;/*Predicates.and(
                PathSelectors.regex(config.getRegex()),
                Predicates.not(*//*PathSelectors.regex("/error.*")*//*)
        );*/
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Parking Lot Api", "Parking Lot", "V1", "Terms of service",
                new Contact("", "", ""), "License of API", "API license URL",
                Collections.emptyList());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(config.getResource().getName()).addResourceLocations(config.getResource().getLocations());
        registry.addResourceHandler(config.getResource().getWeb()) .addResourceLocations(config.getResource().getLocation().getWeb());
    }

}