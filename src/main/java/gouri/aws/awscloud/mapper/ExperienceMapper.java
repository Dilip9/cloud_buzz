package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Experience;
import gouri.aws.awscloud.model.dto.request.ExperienceCreateRequest;
import gouri.aws.awscloud.model.dto.response.ExperienceDto;
import gouri.aws.awscloud.model.dto.update.ExperienceUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    // CreateRequest → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Experience toEntity(ExperienceCreateRequest request);

    // Entity → DTO
    ExperienceDto toDTO(Experience experience);

    // Update mapper
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExperience(ExperienceUpdateRequest request, @MappingTarget Experience entity);
}
