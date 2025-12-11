package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDTO;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;
import gouri.aws.awscloud.r_service.ExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
@Tag(name = "Experience Controller", description = "APIs for managing experience entries in resumes")
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping("/{resumeId}")
    @Operation(summary = "Add Experience to Resume",
            description = "Adds a new experience entry to the specified resume.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Experience created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ExperienceDTO add(@PathVariable Long resumeId,
                             @Valid @RequestBody ExperienceCreateRequest request) {
        return experienceService.add(resumeId, request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Experience",
            description = "Updates an existing experience entry.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Experience updated successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ExperienceDTO update(@PathVariable Long id,
                                @Valid @RequestBody ExperienceUpdateRequest request) {
        return experienceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Experience",
            description = "Deletes an existing experience entry.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Experience deleted successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public void delete(@PathVariable Long id) {
        experienceService.delete(id);
    }
}
