package gouri.aws.awscloud.model.dto.response;

import gouri.aws.awscloud.model.dto.request.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating a new Resume")
public class ResumeDTO {

    @NotBlank(message = "Resume title is required")
    @Size(min = 3, max = 100)
    @Schema(description = "Title of the resume", example = "John Doe")
    private String title;

    @NotBlank(message = "Summary is required")
    @Size(min = 20, max = 1000)
    @Schema(description = "Professional summary", example = "Experienced Java developer with expertise in Spring Boot and microservices.")
    private String summary;

    @NotBlank(message = "Template name is required")
    @Schema(description = "Template used for rendering the resume", example = "Modern")
    private String templateName;

    @Valid
    @Schema(description = "List of experiences associated with the resume")
    private List<ExperienceCreateRequest> experiences;

    @Valid
    @Schema(description = "List of education details")
    private List<EducationCreateRequest> educationList;

    @Valid
    @Schema(description = "List of skills")
    private List<SkillCreateRequest> skills;

    @Valid
    @Schema(description = "List of projects")
    private List<ProjectCreateRequest> projects;

    @Valid
    @Schema(description = "List of certifications")
    private List<CertificationCreateRequest> certifications;
}
