package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeUpdateRequest {

    @Size(min = 3, max = 100, message = "Title must be between 3–100 characters")
    private String title;

    @Size(min = 20, max = 1000, message = "Summary must be between 20–1000 characters")
    private String summary;

    @Size(min = 2, message = "Template name must be valid")
    private String templateName;

    @Valid
    private List<ExperienceUpdateRequest> experiences;

    @Valid
    private List<EducationUpdateRequest> educationList;

    @Valid
    private List<SkillUpdateRequest> skills;

    @Valid
    private List<ProjectUpdateRequest> projects;

    @Valid
    private List<CertificationUpdateRequest> certifications;
}

