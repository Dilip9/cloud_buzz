package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;
import gouri.aws.awscloud.r_service.ProjectService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/{resumeId}")
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody ProjectCreateRequest request) {
        return ApiResponse.ok("Project added", projectService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody ProjectUpdateRequest request) {
        return ApiResponse.ok("Project updated", projectService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ApiResponse.ok("Project deleted", null);
    }
}

