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
@Tag(name = "EducationUpdateRequest", description = "DTO for updating education details")
public class EducationUpdateRequest {

    @Size(max = 200, message = "Institution name cannot exceed 200 characters")
    @Schema(description = "Name of the educational institution", example = "University of Example")
    private String institution;

    @Size(max = 100, message = "Degree cannot exceed 100 characters")
    @Schema(description = "Degree obtained", example = "Bachelor of Science in Computer Science")
    private String degree;

    @Size(max = 100, message = "Field of study cannot exceed 100 characters")
    @Schema(description = "Field of study", example = "Computer Science")
    private String fieldOfStudy;

    @Schema(description = "Start date of the education period", example = "2020-08-15")
    private LocalDate startDate;
    @Schema(description = "End date of the education period", example = "2024-05-20")
    private LocalDate endDate;
}

