package gouri.aws.awscloud.model.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    private Long id;

    private String name;
    private String level;
}
