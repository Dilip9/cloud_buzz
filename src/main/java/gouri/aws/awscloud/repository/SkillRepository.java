package gouri.aws.awscloud.repository;

import gouri.aws.awscloud.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
