package gouri.aws.awscloud.model.dto.request;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationCreateRequest {

    @NotBlank(message = "Certification name is required")
    private String certificationName;

    @NotBlank(message = "Issuer name is required")
    private String issuer;

    @NotNull(message = "Issue date is required")
    private LocalDate issueDate;

    @FutureOrPresent(message = "Expiry date must be in the present or future")
    private LocalDate expiryDate;
}

