package org.ptc.webapp.service;

import java.util.Set;

import org.ptc.webapp.dto.Member;
import org.ptc.webapp.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByLastName(String name);
	Member findById(Long id);
}
