package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDTO;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;
import gouri.aws.awscloud.r_service.ResumeService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @Operation(summary = "Create a new resume", description = "Creates a new resume with nested experiences, education, skills, projects, and certifications")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Resume created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/")
    public ResumeDTO create(@Valid @RequestBody ResumeCreateRequest request) {
        return resumeService.createResume(request);
    }

    @Operation(summary = "Update an existing resume", description = "Updates a resume by its ID")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Resume updated successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Resume not found")
    })
    @PutMapping("/{id}")
    public ResumeDTO update(@PathVariable Long id,
                            @Valid @RequestBody ResumeUpdateRequest request) {
        return resumeService.updateResume(id, request);
    }

    @Operation(summary = "Delete a resume", description = "Deletes a resume by its ID")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Resume deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Resume not found")
    })
    @GetMapping("/{id}")
    public ResumeDTO get(@PathVariable Long id) {
        return resumeService.getResume(id);
    }


}
