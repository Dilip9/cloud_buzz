package gouri.aws.awscloud.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request DTO for creating a new skill")
public class SkillCreateRequest {

    @NotBlank(message = "Skill name is required")
    @Schema(description = "Name of the skill", example = "Java Programming")
    private String name;

    @NotBlank(message = "Skill level is required")
    @Pattern(
            regexp = "Beginner|Intermediate|Advanced|Expert",
            message = "Skill level must be Beginner, Intermediate, Advanced, or Expert"
    )
    @Schema(description = "Proficiency level of the skill", example = "Intermediate")
    private String level;
}

