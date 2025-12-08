package gouri.aws.awscloud.repository;

import gouri.aws.awscloud.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
