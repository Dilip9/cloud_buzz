package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDTO;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;

public interface ExperienceService {
    ExperienceDTO add(Long resumeId, ExperienceCreateRequest request);
    ExperienceDTO update(Long id, ExperienceUpdateRequest request);
    void delete(Long id);
}
