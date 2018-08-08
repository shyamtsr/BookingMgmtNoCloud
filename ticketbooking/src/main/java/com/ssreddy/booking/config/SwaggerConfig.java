package com.ssreddy.booking.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket bookApi() {

		List<Parameter> parameters = new ArrayList<>();

		ParameterBuilder parameterBuilder = new ParameterBuilder();
		parameterBuilder.name("st_token").modelRef(new ModelRef("string")).parameterType("header").required(false)
				.build();

		// return new Docket(DocumentationType.SWAGGER_2).select()
		// .apis(RequestHandlerSelectors.basePackage("com.kkjava.book.ticket.app.controller")).paths(PathSelectors.regex("/cr")).build()
		// .apiInfo(metadata()).globalOperationParameters(parameters);

		parameters.add(parameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ssreddy.booking.controller")).build()
				.apiInfo(metadata()).globalOperationParameters(parameters);

	}

	private ApiInfo metadata() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Rest API", "Ticket Booking Management Info", "1.0", "Tearms of Service",
				"SSReddy", "", "");
		return apiInfo;
	}

}
