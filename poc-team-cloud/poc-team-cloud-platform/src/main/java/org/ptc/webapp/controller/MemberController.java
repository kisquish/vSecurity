package org.ptc.webapp.controller;

import javax.validation.Valid;

import org.ptc.webapp.dto.Member;
import org.ptc.webapp.service.impl.MemberDAO;
import org.ptc.webapp.service.impl.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("mb")
public class MemberController {

//	private static final Logger memberControllerLogger = 
//			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping
	public String getMembers(Model model){
			
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("ourProject", pDAO.findAllMember());
		model.addAttribute("jumTitle", "Members");

		return "members";
	}
	
	@RequestMapping("{id}")
	public String getAMember (@PathVariable("id") Member memb, Model model){
		
		model.addAttribute("proj", mDAO.getProjectLinkedToMember(memb.getId()));
		model.addAttribute("memb", memb);
		model.addAttribute("jumTitle", memb.getSurName());

		return "memberX";
	}
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createMForm(Model model) {

		model.addAttribute("memb", new Member());
		model.addAttribute("jumTitle", "Create a new member");
		
		return "createMemberForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Member memb, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("createMemberForm", "formErrors", result.getAllErrors());
		}
		if (mDAO.saveMember(memb)){
			//System.out.println(memb.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully created a new member");
		return new ModelAndView("redirect:/mb/{memb.id}", "memb.id", memb.getId());
	}
	
	@RequestMapping(value="{id}/d", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("id") String pId, RedirectAttributes redirect) {
		
		mDAO.deleteMember(Long.parseLong(pId));
		return new ModelAndView ("redirect:/mb");
	}
	
	@RequestMapping(value="{id}/u", method = RequestMethod.GET)
	public String updateMForm(@PathVariable("id") String pId, Model model) {
		
		model.addAttribute("memb", mDAO.findMemberX(Long.parseLong(pId)));
		//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
		model.addAttribute("jumTitle", "updating This Member Infos");
		
		return "updateMemberForm";
	}
	
	@RequestMapping(value="{id}/up", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") String pId, @Valid Member memb, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("updateProjectForm", "formErrors", result.getAllErrors());
		}
		memb.setId(Long.parseLong(pId));
		if (mDAO.saveMember(memb)){
			System.out.println(memb.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully update this member");
		return new ModelAndView("redirect:/mb/{memb.id}", "memb.id", memb.getId());
	}
	
}
