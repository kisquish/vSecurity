package com.ptc.finance.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ptc.finance.domain.PTCUserName;

@RepositoryRestResource(collectionResourceRel = "contributors", path = "contributors")
public interface PTCUserNameRepository extends PagingAndSortingRepository<PTCUserName, Long> {

		PTCUserName findByNameAllIgnoringCase(String name);
		List <PTCUserName> findAll();
		
}
