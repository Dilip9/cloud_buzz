package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Skill;
import gouri.aws.awscloud.model.dto.SkillDto;
import gouri.aws.awscloud.model.dto.request.SkillCreateRequest;
import gouri.aws.awscloud.model.dto.update.SkillUpdateRequest;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Skill toEntity(SkillCreateRequest request);

    SkillDto toDTO(Skill skill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSkill(SkillUpdateRequest request, @MappingTarget Skill entity);
}

