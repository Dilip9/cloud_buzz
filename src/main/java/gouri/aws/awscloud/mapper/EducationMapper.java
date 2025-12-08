package gouri.aws.awscloud.mapper;


@Mapper(componentModel = "spring")
public interface EducationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Education toEntity(EducationCreateRequest request);

    EducationDTO toDTO(Education education);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEducation(EducationUpdateRequest request, @MappingTarget Education entity);
}
