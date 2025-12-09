// java
package gouri.aws.awscloud.configuration;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springdoc.core.GroupedOpenApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cloud Buzz - S3 API")
                        .version("v1")
                        .description("API for managing AWS S3 buckets and files. Includes endpoints for bucket lifecycle, object upload/download and metadata.")
                        .contact(new Contact().name("Dilip").email("dilip@example.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local server"),
                        new Server().url("https://api.example.com").description("Production server")
                ))
                .tags(List.of(
                        new Tag().name("Buckets").description("Operations for S3 buckets"),
                        new Tag().name("Objects").description("Operations for S3 objects (upload, download, delete, metadata)"),
                        new Tag().name("Auth").description("Authentication and authorization endpoints")
                ))
                .externalDocs(new ExternalDocumentation().description("Project Docs").url("https://example.com/docs"))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Enter JWT token with Bearer prefix: \\\"Bearer <token>\\\"")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
    }

//    @Bean
//    public GroupedOpenApi awscloudApi() {
//        return GroupedOpenApi.builder()
//                .group("awscloud")
//                .packagesToScan("gouri.aws.awscloud.controller")
//                .build();
//    }
}