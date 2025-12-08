package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.EducationCreateRequest;
import gouri.aws.awscloud.model.dto.update.EducationUpdateRequest;
import gouri.aws.awscloud.r_service.EducationService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/{resumeId}")
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody EducationCreateRequest request) {
        return ApiResponse.ok("Education added", educationService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody EducationUpdateRequest request) {
        return ApiResponse.ok("Education updated", educationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ApiResponse.ok("Education deleted", null);
    }
}

