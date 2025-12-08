package gouri.aws.awscloud.mapper;


import gouri.aws.awscloud.model.Certification;
import gouri.aws.awscloud.model.dto.request.CertificationCreateRequest;
import gouri.aws.awscloud.model.dto.response.CertificationDTO;
import gouri.aws.awscloud.model.dto.update.CertificationUpdateRequest;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface CertificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resume", ignore = true)
    Certification toEntity(CertificationCreateRequest request);

    CertificationDTO toDTO(Certification certification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCertification(CertificationUpdateRequest request, @MappingTarget Certification entity);
}
