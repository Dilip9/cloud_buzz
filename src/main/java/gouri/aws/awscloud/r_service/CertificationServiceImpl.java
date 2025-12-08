package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.mapper.CertificationMapper;
import gouri.aws.awscloud.model.Certification;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.CertificationCreateRequest;
import gouri.aws.awscloud.model.dto.response.CertificationDTO;
import gouri.aws.awscloud.model.dto.update.CertificationUpdateRequest;
import gouri.aws.awscloud.repository.CertificationRepository;
import gouri.aws.awscloud.repository.ResumeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {

    private final ResumeRepository resumeRepository;
    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper;

    @Override
    public CertificationDTO add(Long resumeId, CertificationCreateRequest request) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        Certification certification = certificationMapper.toEntity(request);
        certification.setResume(resume);

        return certificationMapper.toDTO(certificationRepository.save(certification));
    }

    @Override
    public CertificationDTO update(Long id, CertificationUpdateRequest request) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Certification not found"));

        certificationMapper.updateCertification(request, certification);

        return certificationMapper.toDTO(certificationRepository.save(certification));
    }

    @Override
    public void delete(Long id) {
        certificationRepository.deleteById(id);
    }
}

