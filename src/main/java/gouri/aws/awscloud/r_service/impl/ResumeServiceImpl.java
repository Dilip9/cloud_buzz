package gouri.aws.awscloud.r_service.impl;

import gouri.aws.awscloud.mapper.ResumeMapper;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDTO;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;
import gouri.aws.awscloud.r_service.ResumeService;
import gouri.aws.awscloud.repository.ResumeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public ResumeDTO createResume(ResumeCreateRequest request) {
        Resume resume = resumeMapper.toEntity(request);

        Resume saved = resumeRepository.save(resume);

        return resumeMapper.toDTO(saved);
    }

    @Override
    public ResumeDTO updateResume(Long id, ResumeUpdateRequest request) {
        Resume existing = resumeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        resumeMapper.updateResumeFromRequest(request, existing);

        return resumeMapper.toDTO(resumeRepository.save(existing));
    }

    @Override
    public ResumeDTO getResume(Long id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        return resumeMapper.toDTO(resume);
    }

    @Override
    public List<ResumeDTO> getAllResumes() {
        return resumeMapper.toDTOList(resumeRepository.findAll());
    }

    @Override
    public void deleteResume(Long id) {
        if (!resumeRepository.existsById(id)) {
            throw new EntityNotFoundException("Resume not found");
        }
        resumeRepository.deleteById(id);
    }
}

