package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDto;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;
import gouri.aws.awscloud.r_service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping("/{resumeId}")
    public ExperienceDto add(@PathVariable Long resumeId,
                             @Valid @RequestBody ExperienceCreateRequest request) {
        return experienceService.add(resumeId, request);
    }

    @PutMapping("/{id}")
    public ExperienceDto update(@PathVariable Long id,
                                @Valid @RequestBody ExperienceUpdateRequest request) {
        return experienceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        experienceService.delete(id);
    }
}
