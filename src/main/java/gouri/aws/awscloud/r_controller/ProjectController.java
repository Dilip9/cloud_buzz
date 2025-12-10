package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;
import gouri.aws.awscloud.r_service.ProjectService;
import gouri.aws.awscloud.utils.ApiResponse;

import io.swagger.v3.oas.annotations.*;
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
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Project created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Project not found")
    })
    @PostMapping("/{resumeId}")
    public ApiResponse<?> addProject(@PathVariable Long resumeId,
                              @Valid @RequestBody ProjectCreateRequest request) {
        return ApiResponse.ok("Project added", projectService.add(resumeId, request));
    }

    @Operation(summary = "Update a project")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Project updated"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404", description = "Project not found")
    })
    @PutMapping("/{id}")
    public ApiResponse<?> updateProject(@PathVariable Long id,
                                 @Valid @RequestBody ProjectUpdateRequest request) {
        return ApiResponse.ok("Project updated.", projectService.update(id, request));
    }

    @Operation(summary = "Delete a project")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Project deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Project not found")
    })
    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ApiResponse.ok("Project deleted successfully", null);
    }
}

