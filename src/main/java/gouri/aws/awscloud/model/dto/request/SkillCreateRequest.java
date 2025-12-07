package gouri.aws.awscloud.model.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillCreateRequest {

    @NotBlank(message = "Skill name is required")
    private String name;

    @NotBlank(message = "Skill level is required")
    @Pattern(
            regexp = "Beginner|Intermediate|Advanced|Expert",
            message = "Skill level must be Beginner, Intermediate, Advanced, or Expert"
    )
    private String level;
}

