package gouri.aws.awscloud.r_service;


import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDto;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;

import java.util.List;

public interface ResumeService {

    ResumeDto createResume(ResumeCreateRequest request);

    ResumeDto updateResume(Long id, ResumeUpdateRequest request);

    ResumeDto getResume(Long id);

    List<ResumeDto> getAllResumes();

    void deleteResume(Long id);
}

