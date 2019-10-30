package com.tthshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShopKHController {
	@RequestMapping("hethong")
	public String home() {
		return "ShopKH";
	}
}
