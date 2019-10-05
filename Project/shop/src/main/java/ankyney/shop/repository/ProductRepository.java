package ankyney.shop.repository;

public interface ProductRepository {

}
//package com.project.controller;
//
//import java.util.Date;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.project.test;
//import com.project.entities.Order;
//import com.project.entities.OrderDetail;
//import com.project.entities.OrderDetailId;
//import com.project.entities.Product;
//import com.project.services.CategoryService;
//import com.project.services.OrderDetailService;
//import com.project.services.OrderService;
//import com.project.services.ProductService;
//
//@Controller
//public class mainController {
//	@Autowired
//	private JavaMailSender sender;
//
//	@Autowired
//	private CategoryService categoryService;
//
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private OrderService orderService;
//
//	@Autowired
//	private OrderDetailService detailService;
//// trang chu 
//	@RequestMapping(value = { "/", "/home" })
//	public String index(ModelMap model, HttpServletRequest request) {
//		model.addAttribute("categories", categoryService.findAll());
//	//	model.addAttribute("bestSeller", productService.getByBestSeller(5));
//		model.addAttribute("mostViews", productService.getByMostViews(8));
//		return "index";
//	}
//// tat ca san pham
//	@RequestMapping("/allProduct")
//	public String product(ModelMap model) {
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("products", productService.findAll());
//		return "product";
//	}
//// tim kiem san pham bang o tim kiem
//	@GetMapping("/search")
//	public String search(ModelMap model, @RequestParam("searchValue") String value) {
//		model.addAttribute("categories", categoryService.findAll());
//		if (productService.search(value).size() > 0) {
//			model.addAttribute("products", productService.search(value));
//		}
//		return "product";
//	}
////loc san pham theo khoang gia va loai san pham
//	@GetMapping("/searchProduct")
//	public String productFilter(ModelMap model, HttpServletRequest request) {
//
//		String priceRange = request.getParameter("priceRange");
//		String categoryID = request.getParameter("cateID");
//
//		int id = 0;
//		if (categoryID != null) {
//			id = Integer.parseInt(categoryID);
//		}
//		model.addAttribute("categoryID", categoryID);
//		model.addAttribute("categories", categoryService.findAll());
//
//		long[] price = null;
//		if (priceRange != null) {
//			price = test.getPrice(priceRange);
//		}
//		try {
//			if (categoryID == null) {
//				model.addAttribute("priceValue1", price[0]);
//				model.addAttribute("priceValue2", price[1]);
//				if (productService.SearchByPriceRange(price[0], price[1]).size() > 0) {
//					model.addAttribute("products", productService.SearchByPriceRange(price[0], price[1]));
//				}
//			} else if (priceRange == null) {
//				if (productService.searchByCateID(id).size() > 0) {
//					model.addAttribute("products", productService.searchByCateID(id));
//				}
//			} else if (categoryID != null && priceRange != null) {
//				model.addAttribute("priceValue1", price[0]);
//				model.addAttribute("priceValue2", price[1]);
//				if (productService.SearchByCateAndPriceRange(id, price[0], price[1]).size() > 0) {
//					model.addAttribute("products", productService.SearchByCateAndPriceRange(id, price[0], price[1]));
//				}
//			}
//		} catch (NullPointerException e) {
//			System.out.println(e.toString());
//		}
//		return "product";
//	}
//// chi tiet san pham
//	@GetMapping("/productDetail")
//	public String productDetail(ModelMap model, @RequestParam("cateID") int cateID,
//			@RequestParam("productID") int productID) {
//		model.addAttribute("product", productService.findOne(productID));
//		model.addAttribute("relatedProducts", productService.searchByCateID(cateID));
//		return "productDetail";
//	}
//// trang dat hang
//	@GetMapping("/order")
//	public String testLoad(ModelMap model) {
//		model.addAttribute("orderForm", new Order());
//		model.addAttribute("orderDetailForm", new OrderDetail());
//		return "checkout";
//	}
//// xu ly dat hang
//	@PostMapping("/order")
//	public String addOrder(@ModelAttribute("orderForm") Order order, ModelMap model, HttpServletRequest request) {
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		String mail = request.getParameter("mailsend");
//		order.setDate(new Date());
//		System.out.println("Tên: " + order.getCustomerName() + " Địa chỉ: " + order.getAddress());
//		orderService.save(order);
//
//		int noProduct = Integer.parseInt(request.getParameter("noProductInCart"));
//		for (int i = 1; i <= noProduct; i++) {
//			Product product = productService.findByName(request.getParameter("productName" + i));
//			int noProductInCart = Integer.parseInt(request.getParameter("productQuantity" + i));
//
//			int noProductInStock = product.getQuantity();
//			if (noProductInStock > noProductInCart || noProductInStock == noProductInCart) {
//				product.setQuantity(product.getQuantity() - noProductInCart);
//				productService.update(product);
//			}
//
//			long total = product.getPrice() * noProductInCart;
//			OrderDetail orderDetail = new OrderDetail();
//			orderDetail.setId(new OrderDetailId(order.getId(), product.getId()));
//			orderDetail.setOrder(order);
//			orderDetail.setProduct(product);
//			orderDetail.setQuantity(noProductInCart);
//			orderDetail.setAmount(total);
//			detailService.save(orderDetail);
//
//		}
//		try {
//            helper.setTo(mail);
//            helper.setText("Cam on ban da tin tuong va dat hang tai Fishing World. Chung toi se nhanh chong lien lac va giao hang cho ban. Tran trong cam on!");
//            helper.setSubject("[Xac nhan don hang]");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return "Error while sending mail ..";
//        }
//        sender.send(message);
//        return "redirect:/home";
//	}
//// trang gioi thieu
//	@GetMapping("/about")
//	public String contact() {
//		return "about";
//	}
//// trang huong dan
//	@GetMapping("/suport")
//	public String suport() {
//		return "suport";
//	}
//	@GetMapping("/tructuyen")
//	public String tructuyen() {
//		return "tructuyen";
//	}
//	@GetMapping("/muaPC")
//	public String muaPC() {
//		return "muaPC";
//	}
//
//// trang blog kinh nghiem
//	@GetMapping("/blog")
//	public String blog(ModelMap model, HttpServletRequest request) {
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("blogs", productService.forBlog());
//		return "blog";
//	}
//
//	@GetMapping("/detailBlog")
//	public String detailBlog(ModelMap model, @RequestParam("cateID") int cateID,
//			@RequestParam("productID") int productID) {
//		model.addAttribute("product", productService.findOne(productID));
//		model.addAttribute("relatedProducts", productService.searchByCateID(cateID));
//		return "detailBlog";
//	}
//
//}
