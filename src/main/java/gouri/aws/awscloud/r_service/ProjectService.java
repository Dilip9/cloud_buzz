package gouri.aws.awscloud.r_service;

import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.response.ProjectDTO;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;

public interface ProjectService {
    ProjectDTO add(Long resumeId, ProjectCreateRequest request);
    ProjectDTO update(Long id, ProjectUpdateRequest request);
    void delete(Long id);
}
