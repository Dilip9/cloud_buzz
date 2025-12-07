package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUpdateRequest {

    @Size(max = 150, message = "Project name cannot exceed 150 characters")
    private String projectName;

    @Size(max = 3000, message = "Description cannot exceed 3000 characters")
    private String description;

    @Size(max = 500, message = "Technologies string too long")
    private String technologies;
}

