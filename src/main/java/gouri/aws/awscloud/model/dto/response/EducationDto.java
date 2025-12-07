package gouri.aws.awscloud.model.dto.response;



import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

    private Long id;

    private String institution;
    private String degree;
    private String fieldOfStudy;

    private LocalDate startDate;
    private LocalDate endDate;
}

