package gouri.aws.awscloud.model.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceCreateRequest {

    @NotBlank(message = "Company name is required")
    @Size(max = 150)
    private String companyName;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;
}

