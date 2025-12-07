package gouri.aws.awscloud.model.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {

    private Long id;

    private String name;
    private String level;
}
