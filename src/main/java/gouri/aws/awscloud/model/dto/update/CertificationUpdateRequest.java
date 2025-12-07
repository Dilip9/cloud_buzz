package gouri.aws.awscloud.model.dto.update;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationUpdateRequest {

    @Size(max = 200, message = "Certification name cannot exceed 200 characters")
    private String certificationName;

    @Size(max = 200, message = "Issuer name cannot exceed 200 characters")
    private String issuer;

    private LocalDate issueDate;

    @FutureOrPresent(message = "Expiry date must be present or future")
    private LocalDate expiryDate;
}
