package gouri.aws.awscloud.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "ExperienceCreateRequest", description = "Request DTO for creating a new experience entry")
public class ExperienceCreateRequest {

    @NotBlank(message = "Company name is required")
    @Size(max = 150)
    @Schema(description = "Name of the company", example = "Tech Solutions Inc.")
    private String companyName;

    @NotBlank(message = "Job title is required")
    @Schema(description = "Title of the job position", example = "Software Engineer")
    private String jobTitle;

    @NotNull(message = "Start date is required")
    @Schema(description = "Start date of the experience", example = "2020-01-15")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Schema(description = "End date of the experience", example = "2022-06-30")
    private LocalDate endDate;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    @Schema(description = "Description of the job role and responsibilities", example = "Worked on developing scalable web applications...")
    private String description;
}

