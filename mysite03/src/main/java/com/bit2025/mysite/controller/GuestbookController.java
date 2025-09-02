package com.bit2025.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bit2025.mysite.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookService guetbookService;
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("list", guestbookService.getContentsList());
		return "guestbook/index";
	}
	
	@RequestMapping("/add")
	public String add(GuestbookVo guestbookVo) {
		guestbookService.addContents(guestbookVo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		return "/guestbook/delete";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(
		@PathVariable("id") Long id,
		@RequestParam(value="password", required=true, defaultValue="") String password) {
		guestbookService.deleteMessage(id, password);
		return "redirect:/guestbook";
	}
	
}
