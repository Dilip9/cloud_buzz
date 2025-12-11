package gouri.aws.awscloud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "resume_management")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the Experience.", example = "1", required = true)
    private Long id;

    @Schema(description = "Name of the company.", example = "Tech Solutions Inc.", required = true)
    private String companyName;
    @Schema(description = "Job title held at the company.", example = "Software Engineer", required = true)
    private String jobTitle;

    @Schema(description = "Start date of the experience.", example = "2020-01-15", required = true)
    private LocalDate startDate;
    @Schema(description = "End date of the experience.", example = "2022-06-30", required = false)
    private LocalDate endDate;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Description of the job responsibilities and achievements.", example = "Developed and maintained web applications using Java and Spring Boot.", required = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @Schema(description = "The resume to which this experience belongs.", required = true)
    private Resume resume;
}

