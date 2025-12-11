package gouri.aws.awscloud.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating a new project")
public class ProjectCreateRequest {

    @NotBlank(message = "Project name is required")
    @Schema(description = "Project name", example = "AI-Based Resume Analyzer")
    private String projectName;

    @Size(max = 3000, message = "Description cannot exceed 3000 characters")
    @Schema(description = "Project description",
            example = "A tool that analyzes resumes and provides AI-powered recommendations.")
    private String description;

    @NotBlank(message = "Technologies field is required")
    @Schema(description = "Technologies used", example = "Python, FastAPI, OpenAI API")
    private String technologies; // Could also use List<String> with @NotEmpty
}

