package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Project;
import gouri.aws.awscloud.model.dto.request.ProjectCreateRequest;
import gouri.aws.awscloud.model.dto.response.ProjectDto;
import gouri.aws.awscloud.model.dto.update.ProjectUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Project toEntity(ProjectCreateRequest request);

    ProjectDto toDTO(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProject(ProjectUpdateRequest request, @MappingTarget Project entity);
}
