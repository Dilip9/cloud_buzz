package gouri.aws.awscloud.model.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationCreateRequest {

    @NotBlank(message = "Institution name is required")
    private String institution;

    @NotBlank(message = "Degree is required")
    private String degree;

    @NotBlank(message = "Field of study is required")
    private String fieldOfStudy;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;
}

