package org.launchcode.javawebdevtechjobspersistent.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Should extend CrudRepository
// Should be annotated with @Repository

@Repository
public interface EmployerRepository extends CrudRepository {
}
