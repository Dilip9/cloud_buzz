package gouri.aws.awscloud.r_controller;

import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDTO;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;
import gouri.aws.awscloud.r_service.ResumeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResumeDTO create(@Valid @RequestBody ResumeCreateRequest request) {
        return resumeService.createResume(request);
    }

    @PutMapping("/{id}")
    public ResumeDTO update(@PathVariable Long id,
                            @Valid @RequestBody ResumeUpdateRequest request) {
        return resumeService.updateResume(id, request);
    }

    @GetMapping("/{id}")
    public ResumeDTO get(@PathVariable Long id) {
        return resumeService.getResume(id);
    }

    @GetMapping
    public List<ResumeDTO> getAll() {
        return resumeService.getAllResumes();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resumeService.deleteResume(id);
    }
}

