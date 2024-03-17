package com.diegodesjardins.bank.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${api.project.version}")
	private String version;

	@Value("${api.host}")
	private String currentUrl;

	@Bean
	public OpenAPI openApi() {

		return new OpenAPI().servers(Collections.singletonList(new Server().url(currentUrl)))
				.info(new Info().title("API DESJARDINS").description("REST API EXAMPLE").version(version));

	}

}
