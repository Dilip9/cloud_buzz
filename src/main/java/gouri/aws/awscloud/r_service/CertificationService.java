package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.model.dto.request.CertificationCreateRequest;
import gouri.aws.awscloud.model.dto.response.CertificationDTO;
import gouri.aws.awscloud.model.dto.update.CertificationUpdateRequest;

public interface CertificationService {
    CertificationDTO add(Long resumeId, CertificationCreateRequest request);
    CertificationDTO update(Long id, CertificationUpdateRequest request);
    void delete(Long id);
}

