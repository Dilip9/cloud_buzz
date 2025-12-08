package gouri.aws.awscloud.mapper;



@Mapper(componentModel = "spring")
public interface CertificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Certification toEntity(CertificationCreateRequest request);

    CertificationDTO toDTO(Certification certification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCertification(CertificationUpdateRequest request, @MappingTarget Certification entity);
}
