package gouri.aws.awscloud.mapper;


@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    // CreateRequest → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Experience toEntity(ExperienceCreateRequest request);

    // Entity → DTO
    ExperienceDTO toDTO(Experience experience);

    // Update mapper
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExperience(ExperienceUpdateRequest request, @MappingTarget Experience entity);
}
