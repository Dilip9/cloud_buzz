package gouri.aws.awscloud.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating a new Resume")
public class ResumeCreateRequest {

    @NotBlank(message = "Resume title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3–100 characters")
    @Schema(description = "Title of the resume", example = "Senior Software Engineer Resume")
    private String title;

    @NotBlank(message = "Summary is required")
    @Size(min = 20, max = 1000, message = "Summary must be between 20–1000 characters")
    @Schema(description = "Brief summary or objective statement", example = "Experienced software engineer with a passion for developing innovative programs...")
    private String summary;

    @NotBlank(message = "Template name is required")
    @Schema(description = "Name of the resume template to use", example = "ModernProfessional")
    private String templateName;


    @Valid
    @Schema(description = "List of work experiences")
    private List<ExperienceCreateRequest> experiences;

    @Valid
    @Schema(description = "List of educational qualifications")
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

