package gouri.aws.awscloud.model.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Experience Update Request DTO", description = "DTO for updating experience details")
public class ExperienceUpdateRequest {

    @Size(max = 150, message = "Company name cannot exceed 150 characters")
    @Schema(description = "Name of the company", example = "Tech Solutions Inc.")
    private String companyName;

    @Size(max = 150, message = "Job title cannot exceed 150 characters")
    @Schema(description = "Title of the job position", example = "Software Engineer")
    private String jobTitle;

    @Schema(description = "Start date of the experience", example = "2020-01-15")
    private LocalDate startDate;
    @Schema(description = "End date of the experience", example = "2022-06-30")
    private LocalDate endDate;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    @Schema(description = "Description of the job role and responsibilities", example = "Worked on developing scalable web applications...")
    private String description;
}
