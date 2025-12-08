package gouri.aws.awscloud.repository;

import gouri.aws.awscloud.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
