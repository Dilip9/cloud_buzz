package gouri.aws.awscloud.model.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for updating an existing project")
public class ProjectUpdateRequest {

    @Size(max = 150, message = "Project name cannot exceed 150 characters")
    @Schema(description = "Updated project name", example = "Advanced AI Resume Analyzer")
    private String projectName;

    @Size(max = 3000, message = "Description cannot exceed 3000 characters")
    @Schema(description = "Updated description", example = "Enhanced version with ML scoring")
    private String description;

    @Size(max = 500, message = "Technologies string too long")
    @Schema(description = "Updated technologies", example = "Java, Spring Boot, AWS Lambda")
    private String technologies;
}

