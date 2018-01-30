package org.ptc.webapp.controller;

import javax.validation.Valid;

import org.ptc.webapp.dto.Project;
import org.ptc.webapp.service.impl.MemberDAO;
import org.ptc.webapp.service.impl.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("pj")
public class ProjectController {

//	private static final Logger projectControllerLogger = 
//			LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping
	public String getProjects(Model model){
			
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("ourProject", pDAO.findAllMember());
		model.addAttribute("jumTitle", "Projects");
		
		return "projects";
	}
	
	@RequestMapping("{id}")
	public String getAProject (@PathVariable("id") Project proj, Model model){
		
		model.addAttribute("ourTeam", pDAO.getMemberLinkedToProject(proj.getId()));
		model.addAttribute("proj", proj);
		model.addAttribute("jumTitle", proj.getName());

		return "projectX";
	}
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createPForm(@RequestParam("form") String form, Model model) {
			
			model.addAttribute("proj", new Project() );
			//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
			model.addAttribute("jumTitle", "Create a new project");
			
		return "createProjectForm";
	}

	@RequestMapping(value="cr", method = RequestMethod.POST)
	public ModelAndView create(@PathVariable("id") String pId, @Valid Project proj, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("createProjectForm", "formErrors", result.getAllErrors());
		}
		if (pDAO.saveProject(proj)){
			System.out.println(proj.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully created a new project");
		return new ModelAndView("redirect:/pj/{proj.id}", "proj.id", proj.getId());
	}
	
	@RequestMapping(value="{id}/d", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") String pId, RedirectAttributes redirect) {
			
		pDAO.deleteProject(Long.parseLong(pId));	
		return new ModelAndView ("redirect:/pj");
	}
	
	@RequestMapping(value="{id}/u", method = RequestMethod.GET)
	public String updatePForm(@PathVariable("id") String pId, Model model) {
		
		model.addAttribute("proj", pDAO.findProjectX(Long.parseLong(pId)));
		//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
		model.addAttribute("jumTitle", "updating This project");
		
		return "updateProjectForm";
	}
	
	@RequestMapping(value="{id}/up", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") String pId, @Valid Project proj, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("updateProjectForm", "formErrors", result.getAllErrors());
		}
		proj.setId(Long.parseLong(pId));
		if (pDAO.saveProject(proj)){
			System.out.println(proj.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully update this project");
		return new ModelAndView("redirect:/pj/{proj.id}", "proj.id", proj.getId());
	}
	
}
