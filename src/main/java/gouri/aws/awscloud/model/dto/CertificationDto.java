package gouri.aws.awscloud.model.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDto {

    private Long id;

    private String certificationName;
    private String issuer;

    private LocalDate issueDate;
    private LocalDate expiryDate;
}

