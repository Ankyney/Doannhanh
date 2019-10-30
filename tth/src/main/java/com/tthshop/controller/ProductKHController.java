package com.tthshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductKHController {
	@RequestMapping("product")
	public String product() {
		return "ProductKH";
	}

}
