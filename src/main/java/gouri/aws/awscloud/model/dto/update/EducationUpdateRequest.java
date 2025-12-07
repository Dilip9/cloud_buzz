package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationUpdateRequest {

    @Size(max = 200, message = "Institution name cannot exceed 200 characters")
    private String institution;

    @Size(max = 100, message = "Degree cannot exceed 100 characters")
    private String degree;

    @Size(max = 100, message = "Field of study cannot exceed 100 characters")
    private String fieldOfStudy;

    private LocalDate startDate;
    private LocalDate endDate;
}

