package gouri.aws.awscloud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Project entity representing project details in the resume")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the project", example = "777")
    private Long id;

    @Schema(description = "Name of the project", example = "AI-Powered Resume Builder")
    private String projectName;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Detailed description of the project", example = "Developed an AI-powered resume builder that helps users create professional resumes effortlessly.")
    private String description;

    @Schema(description = "Technologies used in the project", example = "Java, Spring Boot, React, AWS")
    private String technologies;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @Schema(description = "Associated resume for the project")
    private Resume resume;
}

