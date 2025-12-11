package gouri.aws.awscloud.configuration;

import org.springframework.context.annotation.Bean;

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
                        .title("Digital Profile Builder API")
                        .version("1.0.0")
                        .description("Enhance your Digital life experience with our cutting-edge API, designed to seamlessly manage your digital profiles across multiple platforms. Our API offers robust features for creating, updating, and retrieving user profiles, ensuring a personalized and secure experience. Whether you're integrating with social media, e-commerce, or any other digital service, our API provides the tools you need to deliver a consistent and engaging user experience.")
                        .contact(new Contact().name("Dilip").email("dilip.verma940805@gmail.com"))
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
                .externalDocs(new ExternalDocumentation().description("Project Docs").url("https://example.com/docs"));
//                .components(new Components()
//                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                                        .description("Enter JWT token with Bearer prefix: \\\"Bearer <token>\\\"")
//                        )
//                )
//                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
    }

}