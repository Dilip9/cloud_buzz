package gouri.aws.awscloud.model.dto.response;



import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "ExperienceDTO", description = "Data Transfer Object for Experience details")
public class ExperienceDTO {

    @Schema(description = "Unique identifier for the experience entry", example = "1")
    private Long id;

    @Schema(description = "Name of the company", example = "Tech Solutions Inc.")
    private String companyName;
    @Schema(description = "Job title held at the company", example = "Software Engineer")
    private String jobTitle;
    @Schema(description = "Start date of the experience", example = "2020-01-15")
    private LocalDate startDate;
    @Schema(description = "End date of the experience", example = "2022-06-30")
    private LocalDate endDate;
    @Schema(description = "Description of the role and responsibilities", example = "Developed and maintained web applications using Java and Spring Boot.")
    private String description;
}

