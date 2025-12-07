package gouri.aws.awscloud.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "education")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institution;
    private String degree;
    private String fieldOfStudy;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

