package com.tthshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ContactKHController {
	@RequestMapping("contact")
	public String home() {
		return "ContactKH";
	}

}
