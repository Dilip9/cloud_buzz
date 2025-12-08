package gouri.aws.awscloud.r_service;


import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDTO;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;

import java.util.List;

public interface ResumeService {

    ResumeDTO createResume(ResumeCreateRequest request);

    ResumeDTO updateResume(Long id, ResumeUpdateRequest request);

    ResumeDTO getResume(Long id);

    List<ResumeDTO> getAllResumes();

    void deleteResume(Long id);
}

