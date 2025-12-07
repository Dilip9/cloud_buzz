package gouri.aws.awscloud.model.dto.request;

import jakarta.validation.Valid;
import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCreateRequest {

    @NotBlank(message = "Resume title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3–100 characters")
    private String title;

    @NotBlank(message = "Summary is required")
    @Size(min = 20, max = 1000, message = "Summary must be between 20–1000 characters")
    private String summary;

    @NotBlank(message = "Template name is required")
    private String templateName;

    // Nested Requests
    @Valid
    private List<ExperienceCreateRequest> experiences;

    @Valid
    private List<EducationCreateRequest> educationList;

    @Valid
    private List<SkillCreateRequest> skills;

    @Valid
    private List<ProjectCreateRequest> projects;

    @Valid
    private List<CertificationCreateRequest> certifications;
}

