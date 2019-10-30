	package com.tthshop.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.validation.Valid;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

import com.tthshop.entities.Admin;
import com.tthshop.entities.Category;
import com.tthshop.entities.Order;
import com.tthshop.entities.Product;
import com.tthshop.services.AdminService;
import com.tthshop.services.CategoryService;
import com.tthshop.services.OrderDetailService;
import com.tthshop.services.OrderService;
import com.tthshop.services.ProductService;

@Controller
public class AdminController {
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService detailService;

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

// them tai khoan moi
	@GetMapping("/signup")
	public String signup(ModelMap model, HttpSession session) {
		model.addAttribute("admin", new Admin());
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("user", adminService.findOne(ad.getId()));
		System.out.println(ad.getId());
		return "signUp";
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

// xu ly them tai khoan moi
	@RequestMapping(value = { "/signupsave" }, method = RequestMethod.POST)
	public String saveAdmin(@Valid Admin admin, BindingResult result, ModelMap model, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("user", adminService.findOne(ad.getId()));
		if (admin.getName().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "name", "nhap name");
			result.addError(ssnError);

			return "signUp";
		}
		if (admin.getUsername().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "username", "nhap username");
			result.addError(ssnError);

			return "signUp";
		}
		if (adminService.findAdminByName(admin.getUsername())) {
			FieldError ssnError = new FieldError("admin", "username", "Username đã tồn tại");
			result.addError(ssnError);
			return "signUp";
		}
		if (adminService.findAdminByEmail(admin.getMailaddress())) {
			FieldError ssnError = new FieldError("admin", "mailaddress", "Email đã tồn tại");
			result.addError(ssnError);
			return "signUp";
		}
		if (admin.getPassword().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "password", "nhap password");
			result.addError(ssnError);
			return "signUp";
		}
		if (admin.getPassword().trim().length() < 6) {
			FieldError ssnError = new FieldError("admin", "password", "password phải có ít nhất 6 kí tự");
			result.addError(ssnError);
			return "signUp";
		} else
			adminService.save(admin);
		return "redirect:/loginAdmin";
	}

//thong ke so san pham theo loai san pham
	@GetMapping("/chartCategory")
	public String chartProductCategory(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("items", productService.productCategory());
		model.addAttribute("user", adminService.findOne(id));
		return "chart";
	}

// thong ke so loai san pham duoc mua 
	@GetMapping("/orderCategory")
	public String orderByCategory(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("orders", orderService.getOrderByCategory());
		model.addAttribute("user", adminService.findOne(id));
		return "chartProductCategory";
	}

////quan ly tai khoan

	@GetMapping("/profileManager")
	public String profile(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("user", adminService.findOne(id));
		return "profileManager";
	}

// trang chinh sua thong tin tai khoan
	@GetMapping("/editProfile")
	public String updateProfile(ModelMap model, @RequestParam("user") int id, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("profileForm", adminService.findOne(id));
		model.addAttribute("user", adminService.findOne(ad.getId()));
		return "editProfile";
	}

//xu ly cap nhat thong tin
	@PostMapping("/saveChangeProfile")
	public String saveChangeProfile(ModelMap model, @Validated @ModelAttribute("profileForm") Admin admin,
			BindingResult validateForm, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		if (admin.getName().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "name", "nhap name");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (admin.getUsername().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "username", "nhap username");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (adminService.findAdminByName(admin.getUsername())) {
			FieldError ssnError = new FieldError("admin", "username", "Username đã tồn tại");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (adminService.findAdminByEmail(admin.getMailaddress())) {
			FieldError ssnError = new FieldError("admin", "mailaddress", "Username đã tồn tại");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (admin.getPassword().trim().length() == 0) {
			FieldError ssnError = new FieldError("admin", "password", "nhap password");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (admin.getPassword().trim().length() < 6) {
			FieldError ssnError = new FieldError("admin", "password", "password phải có ít nhất 6 kí tự");
			validateForm.addError(ssnError);
			model.addAttribute("user", adminService.findOne(ad.getId()));
		} else

			adminService.save(admin);
		return "redirect:/profileManager?user=" + +ad.getId();
	}

	// Start
	// Category-------------------------------------------------------------
	// trang quan ly danh muc
	@GetMapping("/categoryManager")
	public String category(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("user", adminService.findOne(id));
		return "categoryManager";
	}

// xoa danh muc
	@GetMapping("/category/{id}/delete")
	public String deleteCategory(@PathVariable int id, ModelMap model, @RequestParam("user") int userid) {
		categoryService.delete(id);
		model.addAttribute("user", adminService.findOne(userid));
		return "redirect:/categoryManager?user=" + userid;

	}

// them danh muc
	@GetMapping("/addCategory")
	public String addCategory(ModelMap model, HttpSession session) {
		model.addAttribute("categoryForm", new Category());
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("user", adminService.findOne(ad.getId()));
		System.out.println(ad.getId());
		return "formCategory";
	}

// xu ly them danh muc
	@RequestMapping(value = "/categoryManager/save", method = RequestMethod.POST)
	public String saveCategory(ModelMap model, @ModelAttribute("categoryForm") Category category,
			BindingResult validateForm, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");

		if (category.getName().trim().length() == 0) {
			model.addAttribute("user", adminService.findOne(ad.getId()));
			validateForm.rejectValue("name", "category", "vui long nhap ten");
		}
		if (validateForm.hasErrors()) {
			model.addAttribute("user", adminService.findOne(ad.getId()));
			model.addAttribute("message", "vui long sua loi");
		} else {
			model.addAttribute("user", adminService.findOne(ad.getId()));
			model.addAttribute("message", "them moi thanh cong");
			categoryService.save(category);
		}

		return "redirect:/categoryManager?user=" + ad.getId();
	}

// trang chinh sua danh muc
	@GetMapping("/editCategory")
	public String updateCategory(ModelMap model, @RequestParam("cateID") int id, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("categoryForm", categoryService.findOne(id));
		model.addAttribute("user", adminService.findOne(ad.getId()));
		return "formUpdateCategory";
	}

//xu ly chinh sua danh muc
	@PostMapping("/saveChangeCategory")
	public String saveChangeCategory(ModelMap model, @ModelAttribute("categoryForm") Category category,
			BindingResult validateForm, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		if (category.getName().trim().length() == 0) {
			validateForm.rejectValue("name", "category", "vui long nhap ten");
			model.addAttribute("user", adminService.findOne(ad.getId()));
		}
		if (validateForm.hasErrors()) {
			model.addAttribute("message", "vui long sua loi");
			model.addAttribute("user", adminService.findOne(ad.getId()));

		} else {
			model.addAttribute("message", "them moi thanh cong");
			model.addAttribute("user", adminService.findOne(ad.getId()));
			categoryService.save(category);
		}

		return "redirect:/categoryManager?user=" + ad.getId();
	}
	// End Category

	// Start Product
	// ---------------------------------------------------------------------
	// trang chinh sua san pham
	@GetMapping("/editProduct")
	public String updateProduct(ModelMap model, @RequestParam("proID") int id, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("Categories", categoryService.findAll());
		model.addAttribute("productForm", productService.findOne(id));
		model.addAttribute("user", adminService.findOne(ad.getId()));
		return "formUpdateProduct";

	}

// xu ly cap nhat chinh sua san pham
	@PostMapping("/saveChangeProduct")
	public String saveChangeProduct(ModelMap model, @ModelAttribute("productForm") Product product,
			BindingResult validateForm, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		if (product.getName().trim().length() == 0) {
			validateForm.rejectValue("name", "product", "vui long nhap ten");
		}
		if (product.getPrice() < 0) {
			validateForm.rejectValue("price", "product", "gia khong nho hon 0");
		}
		if (product.getQuantity() < 0) {
			validateForm.rejectValue("quantity", "product", "so luong khong nho hon 0");
		}
		if (validateForm.hasErrors()) {
			model.addAttribute("message", "vui long sua loi");
		} else {
			model.addAttribute("message", "them moi thanh cong");
			product.setImage("static/images/" + product.getImage());
			productService.save(product);
		}
		model.addAttribute("user", adminService.findOne(ad.getId()));
		return "redirect:/productManager?user=" + ad.getId();
	}

// trang quan ly san pham
	@GetMapping("/productManager")
	public String product(ModelMap model, @RequestParam("user") int id) {
		model.addAttribute("products", productService.findAll());
		model.addAttribute("user", adminService.findOne(id));
		return "productManager";
	}

//xoa san pham
	@GetMapping("/product/{id}/delete")
	public String deleteProduct(@PathVariable int id, ModelMap model, @RequestParam("user") int userid) {
		productService.delete(id);
		model.addAttribute("user", adminService.findOne(userid));
		return "redirect:/productManager?user=" + userid;
	}

// them san pham
	@GetMapping("/addProduct")
	public String addProduct(ModelMap model, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		model.addAttribute("Categories", categoryService.findAll());
		model.addAttribute("productForm", new Product());
		model.addAttribute("user", adminService.findOne(ad.getId()));
		return "formProduct";
	}

//xu ly them san pham
	@RequestMapping(value = "/productManager/save", method = RequestMethod.POST)
	public String saveProduct(ModelMap model, @ModelAttribute("productForm") Product product,
			BindingResult validateForm, HttpSession session) {
		Admin ad = (Admin) session.getAttribute("userid");
		if (product.getName().trim().length() == 0) {
			validateForm.rejectValue("name", "product", "vui long nhap ten");
		}
		if (product.getPrice() < 0) {
			validateForm.rejectValue("price", "product", "gia khong nho hon 0");
		}
		if (product.getQuantity() < 0) {
			validateForm.rejectValue("quantity", "product", "so luong khong nho hon 0");
		}
		if (validateForm.hasErrors()) {
			model.addAttribute("message", "vui long sua loi");

		} else {
			model.addAttribute("user", adminService.findOne(ad.getId()));
			model.addAttribute("message", "them moi thanh cong");
			product.setImage("static/images/anvat/" + product.getImage());
			
			productService.save(product);
		}

		return "redirect:/productManager?user=" + ad.getId();
	}

}
