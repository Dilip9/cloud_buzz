package gouri.aws.awscloud.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificationName;
    private String issuer;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

