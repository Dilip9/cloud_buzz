package gouri.aws.awscloud.model.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request DTO for updating a skill")
public class SkillUpdateRequest {

    @Size(max = 100, message = "Skill name cannot exceed 100 characters")
    @Schema(description = "Name of the skill", example = "Java Programming")
    private String name;

    @Pattern(
            regexp = "Beginner|Intermediate|Advanced|Expert",
            message = "Skill level must be Beginner, Intermediate, Advanced, or Expert"
    )
    @Schema(description = "Proficiency level of the skill", example = "Advanced")
    private String level;
}
