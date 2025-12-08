package gouri.aws.awscloud.r_service;


import gouri.aws.awscloud.model.dto.request.EducationCreateRequest;
import gouri.aws.awscloud.model.dto.response.EducationDTO;
import gouri.aws.awscloud.model.dto.update.EducationUpdateRequest;

public interface EducationService {
    EducationDTO add(Long resumeId, EducationCreateRequest request);
    EducationDTO update(Long id, EducationUpdateRequest request);
    void delete(Long id);
}
