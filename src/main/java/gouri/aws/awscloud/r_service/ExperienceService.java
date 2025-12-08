package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDto;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;

public interface ExperienceService {
    ExperienceDto add(Long resumeId, ExperienceCreateRequest request);
    ExperienceDto update(Long id, ExperienceUpdateRequest request);
    void delete(Long id);
}
