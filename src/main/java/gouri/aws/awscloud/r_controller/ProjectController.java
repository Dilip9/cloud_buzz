package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.response.ProjectDTO;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;
import gouri.aws.awscloud.r_service.ProjectService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse as SwaggerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@Tag(name = "Project", description = "APIs for managing project information in resumes")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "Create a new project",
            description = "Adds a new project to a resume")
    @SwaggerResponse(responseCode = "200", description = "Project created successfully", content = @Content(schema = @Schema(implementation = ProjectDTO.class)))
    @PostMapping("/{resumeId}")
    public ApiResponse<?> addProject(@PathVariable Long resumeId,
                              @Valid @RequestBody ProjectCreateRequest request) {
        return ApiResponse.ok("Project added", projectService.add(resumeId, request));
    }

    @Operation(summary = "Update a project")
    @SwaggerResponse(responseCode = "200", description = "Project updated successfully")
    @PutMapping("/{id}")
    public ApiResponse<?> updateProject(@PathVariable Long id,
                                 @Valid @RequestBody ProjectUpdateRequest request) {
        return ApiResponse.ok("Project updated.", projectService.update(id, request));
    }

    @Operation(summary = "Delete a project")
    @SwaggerResponse(responseCode = "200", description = "Project deleted successfully")
    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ApiResponse.ok("Project deleted successfully", null);
    }
}

