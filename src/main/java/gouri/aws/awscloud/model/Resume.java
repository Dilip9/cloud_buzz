package gouri.aws.awscloud.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


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
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String templateName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships ----->

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educationList;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
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


