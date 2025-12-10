package gouri.aws.awscloud.model.dto.response;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing project details")
public class ProjectDTO {

    @Schema(description = "Project ID", example = "101")
    private Long id;
    @Schema(description = "Project name", example = "AI Resume Builder")
    private String projectName;
    @Schema(description = "Project description", example = "An AI-powered resume builder that helps users create professional resumes effortlessly.")
    private String description;
    @Schema(description = "Technologies used in the project", example = "Java, Spring Boot, React, AWS")
    private String technologies;  // String or List<String>
}

