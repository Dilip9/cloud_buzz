package gouri.aws.awscloud.model.dto.response;

import gouri.aws.awscloud.model.dto.EducationDTO;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {

    private Long id;

    private String title;
    private String summary;
    private String templateName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Child DTOs
    private List<ExperienceDTO> experiences;
    private List<EducationDTO> educationList;
    private List<SkillDTO> skills;
    private List<ProjectDTO> projects;
    private List<CertificationDTO> certifications;
}

