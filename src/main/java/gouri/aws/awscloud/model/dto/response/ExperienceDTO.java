package gouri.aws.awscloud.model.dto.response;



import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

    private Long id;

    private String companyName;
    private String jobTitle;

    private LocalDate startDate;
    private LocalDate endDate;

    private String description;
}

