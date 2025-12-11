package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.EducationCreateRequest;
import gouri.aws.awscloud.model.dto.update.EducationUpdateRequest;
import gouri.aws.awscloud.r_service.EducationService;
import gouri.aws.awscloud.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
@Tag(name = "Education Controller", description = "APIs for managing education details in resumes")
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/{resumeId}")
    @Operation(description = "Add education to resume", method = "POST")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Education created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody EducationCreateRequest request) {
        return ApiResponse.ok("Education added", educationService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    @Operation(description = "Update education", method = "PUT")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Education updated successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody EducationUpdateRequest request) {
        return ApiResponse.ok("Education updated", educationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete education", method = "DELETE")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "Education deleted successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "Internal server error")
    })
    public ApiResponse<?> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ApiResponse.ok("Education deleted", null);
    }
}

