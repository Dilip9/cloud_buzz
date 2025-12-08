package gouri.aws.awscloud.mapper;


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
    ResumeDTO toDTO(Resume resume);

    List<ResumeDTO> toDTOList(List<Resume> resumes);

    // Update existing entity (PATCH / PUT)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResumeFromRequest(ResumeUpdateRequest request, @MappingTarget Resume resume);
}

