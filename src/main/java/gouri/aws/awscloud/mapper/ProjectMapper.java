package gouri.aws.awscloud.mapper;


@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Project toEntity(ProjectCreateRequest request);

    ProjectDTO toDTO(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProject(ProjectUpdateRequest request, @MappingTarget Project entity);
}
