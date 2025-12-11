package gouri.aws.awscloud.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "CertificationCreateRequest", description = "Request DTO for creating a new certification")
public class CertificationCreateRequest {

    @NotBlank(message = "Certification name is required")
    @Schema(description = "Name of the certification", example = "AWS Certified Solutions Architect")
    private String certificationName;

    @NotBlank(message = "Issuer name is required")
    @Schema(description = "Name of the certification issuer", example = "Amazon Web Services")
    private String issuer;

    @NotNull(message = "Issue date is required")
    @Schema(description = "Date when the certification was issued", example = "2023-01-15")
    private LocalDate issueDate;

    @FutureOrPresent(message = "Expiry date must be in the present or future")
    @Schema(description = "Expiry date of the certification", example = "2025-01-15")
    private LocalDate expiryDate;
}

