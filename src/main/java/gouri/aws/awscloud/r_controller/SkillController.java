package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.SkillCreateRequest;
import gouri.aws.awscloud.model.dto.update.SkillUpdateRequest;
import gouri.aws.awscloud.r_service.SkillService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@Tag(name = "Skill", description = "APIs for Skill information in resumes")
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/{resumeId}")
    @Operation(summary = "Create a new Skill", description = "Adds a new skill to the specified resume")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Skill created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody SkillCreateRequest request) {
        return ApiResponse.ok("Skill added", skillService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Skill", description = "Updates the details of an existing skill")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Skill updated successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody SkillUpdateRequest request) {
        return ApiResponse.ok("Skill updated", skillService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Skill", description = "Deletes the specified skill")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Skill deleted successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> delete(@PathVariable Long id) {
        skillService.delete(id);
        return ApiResponse.ok("Skill deleted", null);
    }
}

