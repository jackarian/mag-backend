/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ariannamondo.mag.config.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author jackarian
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig  extends WebMvcConfigurationSupport{
    public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.
                                        basePackage("it.ariannamondo.mag")).
                                  paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);	}
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	private ApiInfo apiInfo() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("REST API");
		apiInfoBuilder.description("REST API Generation");
		apiInfoBuilder.version("1.0.0");
		apiInfoBuilder.license("GNU GENERAL PUBLIC LICENSE, Version 3");
		apiInfoBuilder.licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html");
		return apiInfoBuilder.build();
	}
}
