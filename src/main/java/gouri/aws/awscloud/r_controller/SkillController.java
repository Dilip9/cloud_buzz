package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.SkillCreateRequest;
import gouri.aws.awscloud.model.dto.update.SkillUpdateRequest;
import gouri.aws.awscloud.r_service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/{resumeId}")
    public ApiResponse<?> add(@PathVariable Long resumeId,
                              @Valid @RequestBody SkillCreateRequest request) {
        return ApiResponse.ok("Skill added", skillService.add(resumeId, request));
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Long id,
                                 @Valid @RequestBody SkillUpdateRequest request) {
        return ApiResponse.ok("Skill updated", skillService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        skillService.delete(id);
        return ApiResponse.ok("Skill deleted", null);
    }
}

