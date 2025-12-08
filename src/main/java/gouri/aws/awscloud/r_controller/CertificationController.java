package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.CertificationCreateRequest;
import gouri.aws.awscloud.model.dto.update.CertificationUpdateRequest;
import gouri.aws.awscloud.r_service.CertificationService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certifications")
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @PostMapping("/{resumeId}")
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody CertificationCreateRequest request) {
        return ApiResponse.ok("Certification added", certificationService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody CertificationUpdateRequest request) {
        return ApiResponse.ok("Certification updated", certificationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        certificationService.delete(id);
        return ApiResponse.ok("Certification deleted", null);
    }
}

