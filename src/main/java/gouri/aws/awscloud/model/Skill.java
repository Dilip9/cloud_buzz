package gouri.aws.awscloud.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Skill entity representing a skill in a resume")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the skill", example = "1")
    private Long id;

    @Schema(description = "Name of the skill", example = "Java Programming")
    private String name;
    @Schema(description = "Proficiency level of the skill", example = "Intermediate")
    private String level;  // Beginner / Intermediate / Expert (optional)

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @Schema(description = "The resume associated with this skill")
    private Resume resume;
}

