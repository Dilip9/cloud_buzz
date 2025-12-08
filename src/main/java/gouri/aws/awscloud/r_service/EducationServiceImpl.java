package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.mapper.EducationMapper;
import gouri.aws.awscloud.model.Education;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.EducationCreateRequest;
import gouri.aws.awscloud.model.dto.response.EducationDTO;
import gouri.aws.awscloud.model.dto.update.EducationUpdateRequest;
import gouri.aws.awscloud.repository.EducationRepository;
import gouri.aws.awscloud.repository.ResumeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final ResumeRepository resumeRepository;
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    @Override
    public EducationDTO add(Long resumeId, EducationCreateRequest request) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        Education education = educationMapper.toEntity(request);
        education.setResume(resume);

        return educationMapper.toDTO(educationRepository.save(education));
    }

    @Override
    public EducationDTO update(Long id, EducationUpdateRequest request) {
        Education edu = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));

        educationMapper.updateEducation(request, edu);

        return educationMapper.toDTO(educationRepository.save(edu));
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }
}

