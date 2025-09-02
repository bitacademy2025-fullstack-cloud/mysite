package com.bit2025.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bit2025.mysite.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookService guetbookService;
	
	
}
