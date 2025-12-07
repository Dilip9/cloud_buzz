package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillUpdateRequest {

    @Size(max = 100, message = "Skill name cannot exceed 100 characters")
    private String name;

    @Pattern(
            regexp = "Beginner|Intermediate|Advanced|Expert",
            message = "Skill level must be Beginner, Intermediate, Advanced, or Expert"
    )
    private String level;
}
