package d6g.win.resource.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("知识站点")
//                        .description("Swagger3 文档")
//                        .version("v1"))
//                .externalDocs(new ExternalDocumentation()
//                        .description("项目API文档")
//                        .url("/swagger"));
//    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Micro service")
                        .description("APIs for Test Console service")
                        .version("1.0")
                        .license(new License().name("Dev Team").url("https://github.com"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Test Documentation")
                        .url("https://github.com")
                );
    }

    @Bean
    public GroupedOpenApi publicApi () {
        return GroupedOpenApi.builder()
                .group("test-api")
                .pathsToMatch("/api/**")
                .build();
    }
}
