package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.model.dto.request.SkillCreateRequest;
import gouri.aws.awscloud.model.dto.response.SkillDTO;
import gouri.aws.awscloud.model.dto.update.SkillUpdateRequest;

public interface SkillService {
    SkillDTO add(Long resumeId, SkillCreateRequest request);
    SkillDTO update(Long id, SkillUpdateRequest request);
    void delete(Long id);
}
