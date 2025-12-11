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
@Tag(name = "EducationCreateRequest", description = "Request DTO for creating an education entry")
public class EducationCreateRequest {

    @NotBlank(message = "Institution name is required")
    @Schema(description = "Name of the educational institution", example = "University of Example")
    private String institution;

    @NotBlank(message = "Degree is required")
    @Schema(description = "Degree obtained", example = "Bachelor of Science")
    private String degree;

    @NotBlank(message = "Field of study is required")
    @Schema(description = "Field of study", example = "Computer Science")
    private String fieldOfStudy;

    @NotNull(message = "Start date is required")
    @Schema(description = "Start date of the education period", example = "2020-08-15")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Schema(description = "End date of the education period", example = "2024-05-20")
    private LocalDate endDate;
}

