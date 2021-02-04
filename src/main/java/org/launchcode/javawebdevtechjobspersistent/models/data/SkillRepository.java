package org.launchcode.javawebdevtechjobspersistent.models.data;

// Should extend CrudRepository
// Should be annotated with @Repository

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository {
}
