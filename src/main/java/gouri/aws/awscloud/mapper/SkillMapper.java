package gouri.aws.awscloud.mapper;


@Mapper(componentModel = "spring")
public interface SkillMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Skill toEntity(SkillCreateRequest request);

    SkillDTO toDTO(Skill skill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSkill(SkillUpdateRequest request, @MappingTarget Skill entity);
}

