package org.ptc.webapp.controller;

import java.util.List;

import org.ptc.webapp.dto.Member;
import org.ptc.webapp.dto.Project;
import org.ptc.webapp.service.impl.MemberDAO;
import org.ptc.webapp.service.impl.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProjectAcc{
	
	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	private Iterable<Member> team;
	private Iterable<Project> proj;
	
// 	private static final Logger logController = LoggerFactory.getLogger(ProjectAcc.class);
//	private static final String PATH = "/error";
	
	@Value("${qui.n: Aetsmtl}")
	private String qui;
	
	@RequestMapping("/")
	public String indexConnexion(Model model){
				
		team = mDAO.findAllMember();
		proj = pDAO.findAllMember();
		
		List<Project> lp = (List<Project>)proj ;
		List<Member> lm = (List<Member>)team;
		
		int lastIndex = ((List<Project>)proj).size();
		
		if (checkIfListSizeOfProjectIsMoreThanThree (proj)){
			lp = ((List<Project>)proj).subList(lastIndex-2, lastIndex);
		}
		
		lastIndex = ((List<Member>)team).size();
		
		if (checkIfListSizeOfMemberIsMoreThanThree(team)){
			lm = ((List<Member>)team).subList(lastIndex-2, lastIndex);
		}

		model.addAttribute("ourTeam", lm);
		model.addAttribute("ourProject", lp);
		model.addAttribute("jumTitle", "Welcome to Poc-Team-Cloud [ P.T.C. ]");
		
		return "index";
	}
	
	@RequestMapping(value="/portfolio")
	public String getAPortfolio(){
	
		return "portfolio";
	}
	
	@RequestMapping("/aboutUs")
	public String aboutsUs(Model model){
				
		team = mDAO.findAllMember();
		proj = pDAO.findAllMember();

		model.addAttribute("ourTeam", team);
		model.addAttribute("ourProject", proj);
		model.addAttribute("jumTitle", "Everything about US!");

		
		return "aboutUs";
	}
	
	private boolean checkIfListSizeOfProjectIsMoreThanThree(Iterable<Project> proj2) {
		// TODO Auto-generated method stub
		if (proj2 == null || 
				((List<Project>)proj2).isEmpty() || 
				((List<Project>)proj2).size() <= 1){
					return false;
				}
		return true;
	}
	
	private boolean checkIfListSizeOfMemberIsMoreThanThree(Iterable<Member> memb) {
		// TODO Auto-generated method stub
		if (memb == null || 
				((List<Member>)memb).isEmpty() || 
				((List<Member>)memb).size() <= 1){
					return false;
				}
		return true;
	}
	
}
