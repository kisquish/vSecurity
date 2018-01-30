package org.ptc.webapp.service;

import org.ptc.webapp.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	Project findByName(String name);
	Project findById(Long id);
	
}
