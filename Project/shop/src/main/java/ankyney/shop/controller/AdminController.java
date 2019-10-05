package ankyney.shop.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.MessageSource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.annotation.SessionAttributesHandler;

import ankyney.shop.entities.Admin;

import ankyney.shop.services.AdminService;


@Controller
public class AdminController {


	@Autowired
	private AdminService adminService;


// Dang xuat
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/loginAdmin";
	}

// trang login
	@GetMapping("/loginAdmin")
	public String index(ModelMap model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "login";
	}

// trang chu admin
	@GetMapping("/admin")
	public String index2(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("user", adminService.findOne(id));
		return "ad_index";
	}

//xu ly dang nhap
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String saveLogin(@Valid Admin admin, BindingResult result, ModelMap model, HttpSession session) {

		if (admin.getUsername().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "username", "nhap username");
			result.addError(ssnError);
			return "login";
		}
		if (admin.getPassword().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "password", "nhap password");
			result.addError(ssnError);
			return "login";
		}
		if (!adminService.findAdminByName(admin.getUsername())) {
			FieldError ssnError = new FieldError("admin", "username", "username không tồn tại");
			result.addError(ssnError);
			return "login";
		}
		if (!adminService.findByName(admin.getUsername()).getPassword().equals(admin.getPassword())) {
			FieldError ssnError = new FieldError("admin", "password", "password không chính xác");
			result.addError(ssnError);
			return "login";
		} else
			model.addAttribute("user", adminService.findByName(admin.getUsername()));
		session.setAttribute("userid", adminService.findByName(admin.getUsername()));
		return "ad_index";
	}

}