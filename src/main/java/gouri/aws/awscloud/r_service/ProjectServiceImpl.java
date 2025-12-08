package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.mapper.ProjectMapper;
import gouri.aws.awscloud.model.Project;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.response.ProjectDTO;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;
import gouri.aws.awscloud.repository.ProjectRepository;
import gouri.aws.awscloud.repository.ResumeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ResumeRepository resumeRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectDTO add(Long resumeId, ProjectCreateRequest request) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        Project project = projectMapper.toEntity(request);
        project.setResume(resume);

        return projectMapper.toDTO(projectRepository.save(project));
    }

    @Override
    public ProjectDTO update(Long id, ProjectUpdateRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        projectMapper.updateProject(request, project);

        return projectMapper.toDTO(projectRepository.save(project));
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}

