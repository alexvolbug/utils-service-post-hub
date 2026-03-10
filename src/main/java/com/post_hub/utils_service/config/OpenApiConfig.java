package com.post_hub.utils_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "'POST_HUB' REST API",
                version = "1.0",
                description = """
                        UTILS-service handles system notifications, audit logs, and read status management.

                        - Fetch action logs by ID
                        - Mark logs as read
                        - Paginated log search

                        Created by Aleksey Volchenko | [Send me email](mailto:alexvolbug@gmail.com)""",
                contact = @Contact(name = "POST_HUB")),
        security = { @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)}
)
@SecurityScheme(
        name = HttpHeaders.AUTHORIZATION,
        type = SecuritySchemeType.HTTP,
        scheme = "Bearer",
        bearerFormat = "JWT"
)
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi utilsApi() {
        return GroupedOpenApi.builder()
                .group("utils-service")
                .packagesToScan("com.post_hub.utils_service.controller")
                .build();
    }
}