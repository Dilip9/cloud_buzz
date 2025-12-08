package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.mapper.ExperienceMapper;
import gouri.aws.awscloud.model.Experience;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDTO;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;
import gouri.aws.awscloud.repository.ExperienceRepository;
import gouri.aws.awscloud.repository.ResumeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ResumeRepository resumeRepository;
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    @Override
    public ExperienceDTO add(Long resumeId, ExperienceCreateRequest request) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        Experience experience = experienceMapper.toEntity(request);
        experience.setResume(resume);

        return experienceMapper.toDTO(experienceRepository.save(experience));
    }

    @Override
    public ExperienceDTO update(Long id, ExperienceUpdateRequest request) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experience not found"));

        experienceMapper.updateExperience(request, experience);

        return experienceMapper.toDTO(experienceRepository.save(experience));
    }

    @Override
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}

