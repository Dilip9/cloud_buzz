package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Education;
import gouri.aws.awscloud.model.dto.request.EducationCreateRequest;
import gouri.aws.awscloud.model.dto.response.EducationDTO;
import gouri.aws.awscloud.model.dto.update.EducationUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Education toEntity(EducationCreateRequest request);

    EducationDTO toDTO(Education education);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEducation(EducationUpdateRequest request, @MappingTarget Education entity);
}
