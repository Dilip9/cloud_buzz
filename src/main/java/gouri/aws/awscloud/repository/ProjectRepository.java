package gouri.aws.awscloud.repository;

import gouri.aws.awscloud.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
