package org.ptc.webapp.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ptc.webapp.dto.Member;
import org.ptc.webapp.dto.Project;
import org.ptc.webapp.service.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

	private static final Logger logProjectDAO = LoggerFactory.getLogger(MemberDAO.class);

	MemberRepository memberRepo;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		// For Spring
	}
	
	@Autowired
	public void setProjectRepo(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}
	
	public MemberDAO (MemberRepository memberRepo){
		logProjectDAO.info("Instantiation of MEMBERREPOSITORY $$$$$");
		setProjectRepo(memberRepo);
	}
	
	public boolean saveMember (Member p){
		logProjectDAO.info("Saving a member $$$$$");
		if (p.equals(memberRepo.save(p))){
			return true;
		}
		return false;
	}
	
	public Member findMemberX (long Xid){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return memberRepo.findById(Xid);
	}
	
	public Iterable<Member> findAllMember (){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return memberRepo.findAll();
	}

	public void deleteMember (Long pId){
		logProjectDAO.info("Deleting a member $$$$$");
		//projectRepo.delete(p);
		memberRepo.delete(pId);
	}

	public Set<Project> getProjectLinkedToMember(long memberId){
		
		Set<Project> sProject = new HashSet<>();
		sProject = memberRepo.findById(memberId).getProject_Member();
		
		return sProject;
	}
}
