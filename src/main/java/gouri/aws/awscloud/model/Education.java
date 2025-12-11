package gouri.aws.awscloud.model;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "education")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Education", description = "Education details associated with a resume")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the education record", example = "1", required = true)
    private Long id;
    @Schema(description = "Name of the educational institution", example = "University of Example", required = true)
    private String institution;
    @Schema(description = "Degree obtained", example = "Bachelor of Science", required = true)
    private String degree;
    @Schema(description = "Field of study", example = "Computer Science", required = true)
    private String fieldOfStudy;
    @Schema(description = "Start date of the education period", example = "2020-08-15", required = true)
    private LocalDate startDate;
    @Schema(description = "End date of the education period", example = "2024-05-20", required = true)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @Schema(description = "Resume associated with this education record", required = true)
    private Resume resume;
}

