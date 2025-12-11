package gouri.aws.awscloud.r_service.impl;

import gouri.aws.awscloud.mapper.SkillMapper;
import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.Skill;
import gouri.aws.awscloud.model.dto.request.SkillCreateRequest;
import gouri.aws.awscloud.model.dto.response.SkillDTO;
import gouri.aws.awscloud.model.dto.update.SkillUpdateRequest;
import gouri.aws.awscloud.r_service.SkillService;
import gouri.aws.awscloud.repository.ResumeRepository;
import gouri.aws.awscloud.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final ResumeRepository resumeRepository;
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillDTO add(Long resumeId, SkillCreateRequest request) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new EntityNotFoundException("Resume not found"));

        Skill skill = skillMapper.toEntity(request);
        skill.setResume(resume);

        return skillMapper.toDTO(skillRepository.save(skill));
    }

    @Override
    public SkillDTO update(Long id, SkillUpdateRequest request) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found"));

        skillMapper.updateSkill(request, skill);

        return skillMapper.toDTO(skillRepository.save(skill));
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}

