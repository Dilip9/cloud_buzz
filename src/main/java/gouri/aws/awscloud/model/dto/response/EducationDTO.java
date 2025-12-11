package gouri.aws.awscloud.model.dto.response;



import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "EducationDTO", description = "Data Transfer Object for Education details")
public class EducationDTO {

    @Schema(description = "Unique identifier for the education record", example = "1")
    private Long id;
    @Schema(description = "Name of the educational institution", example = "University of Example")
    private String institution;
    @Schema(description = "Degree obtained", example = "Bachelor of Science")
    private String degree;
    @Schema(description = "Field of study", example = "Computer Science")
    private String fieldOfStudy;
    @Schema(description = "Start date of the education period", example = "2020-08-15")
    private LocalDate startDate;
    @Schema(description = "End date of the education period", example = "2024-05-20")
    private LocalDate endDate;
}

