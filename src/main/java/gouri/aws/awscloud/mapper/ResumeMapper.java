package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Resume;
import gouri.aws.awscloud.model.dto.request.ResumeCreateRequest;
import gouri.aws.awscloud.model.dto.response.ResumeDto;
import gouri.aws.awscloud.model.dto.update.ResumeUpdateRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ExperienceMapper.class,
                EducationMapper.class,
                SkillMapper.class,
                ProjectMapper.class,
                CertificationMapper.class
        }
)
public interface ResumeMapper {

    // CreateRequest → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Resume toEntity(ResumeCreateRequest request);

    // Entity → DTO
    ResumeDto toDTO(Resume resume);

    List<ResumeDto> toDTOList(List<Resume> resumes);

    // Update existing entity (PATCH / PUT)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResumeFromRequest(ResumeUpdateRequest request, @MappingTarget Resume resume);
}

