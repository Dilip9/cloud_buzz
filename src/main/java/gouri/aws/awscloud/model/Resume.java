package gouri.aws.awscloud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resumes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Resume entity storing summary, personal details, and associated user information")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique ID of the resume", example = "1")
    private Long id;

    @Schema(description = "Full name or title of the resume", example = "John Doe")
    private String title;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Summary or professional objective",
            example = "Experienced Java developer skilled in Spring Boot and microservices.")
    private String summary;

    @Schema(description = "Name of the template used for rendering", example = "Modern")
    private String templateName;

    @Schema(description = "Timestamp when the resume was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the resume was last updated")
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of work experiences associated with the resume")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of education details associated with the resume")
    private List<Education> educationList;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of skills included in the resume")
    private List<Skill> skills;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of projects completed by the candidate")
    private List<Project> projects;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of certifications acquired by the candidate")
    private List<Certification> certifications;


    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
