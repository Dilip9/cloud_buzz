package gouri.aws.awscloud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String technologies;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

