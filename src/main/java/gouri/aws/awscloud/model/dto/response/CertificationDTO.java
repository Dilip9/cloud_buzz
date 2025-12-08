package gouri.aws.awscloud.model.dto.response;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDTO {

    private Long id;

    private String certificationName;
    private String issuer;

    private LocalDate issueDate;
    private LocalDate expiryDate;
}

