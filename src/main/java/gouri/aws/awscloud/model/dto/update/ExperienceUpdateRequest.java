package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceUpdateRequest {

    @Size(max = 150, message = "Company name cannot exceed 150 characters")
    private String companyName;

    @Size(max = 150, message = "Job title cannot exceed 150 characters")
    private String jobTitle;

    private LocalDate startDate;
    private LocalDate endDate;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;
}
