package gouri.aws.awscloud.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Skill information")
public class SkillDTO {

    @Schema(description = "Unique identifier of the Skill", example = "1")
    private Long id;

    @Schema(description = "Name of the Skill", example = "Java Programming")
    private String name;
    @Schema(description = "Proficiency level of the Skill", example = "Expert")
    private String level;
}
