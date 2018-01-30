package org.ptc.webapp.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.ptc.webapp.dto.Member;
import org.ptc.webapp.dto.Project;
import org.ptc.webapp.service.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDAO {

	private static final Logger logProjectDAO = LoggerFactory.getLogger(ProjectDAO.class);

	ProjectRepository projectRepo;
	
	public ProjectDAO() {
		// TODO Auto-generated constructor stub
		// For Spring
	}
	
	@Autowired
	public void setProjectRepo(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public ProjectDAO (ProjectRepository projectRepository){
		logProjectDAO.info("Instantiation of PROJECTREPOSITORY $$$$$");
		setProjectRepo(projectRepository);
	}
	
	public boolean saveProject (Project p){
		logProjectDAO.info("Saving a Project $$$$$");
		logProjectDAO.info(" id of this project "+p.getId());
		if (p.equals(projectRepo.save(p))){
			
			return true;
		}
		return false;
	}
	
	public void deleteProject (Long pId){
		logProjectDAO.info("Deleting an Project $$$$$");
		//projectRepo.delete(p);
		projectRepo.delete(pId);
	}
	
	public Project findProjectX (long Xid){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return projectRepo.findById(Xid);
	}
	
	public Iterable<Project> findAllMember (){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return projectRepo.findAll();
	}

	public Set<Member> getMemberLinkedToProject(long projectId){
	
		Set<Member> sMember = new HashSet<Member>();
		sMember = projectRepo.findById(projectId).getContributors();
		
		return sMember;
	}

}
