package gouri.aws.awscloud.model.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateRequest {

    @NotBlank(message = "Project name is required")
    private String projectName;

    @Size(max = 3000, message = "Description cannot exceed 3000 characters")
    private String description;

    @NotBlank(message = "Technologies field is required")
    private String technologies; // Could also use List<String> with @NotEmpty
}

