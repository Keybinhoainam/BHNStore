package B19DCCN445.Controller.customer;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import B19DCCN445.domain.Account;
import B19DCCN445.domain.CartItem;
import B19DCCN445.domain.Order;
import B19DCCN445.domain.OrderDetail;
import B19DCCN445.domain.Product;
import B19DCCN445.service.CartItemService;
import B19DCCN445.service.OrderDetailService;
import B19DCCN445.service.OrderService;
import B19DCCN445.service.ProductService;



@Controller
@RequestMapping("/customer/cart/checkout")
public class CheckoutController {
	@Autowired
	OrderService orderService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ProductService productService;
	@Autowired
	HttpSession session;
	@GetMapping("")
	public String checkout(Model model) {
		Long accountid=(Long) session.getAttribute("accountid");
		if(accountid==null) {
			return "login";
		}
		Order o=new Order();
		
		model.addAttribute("order",o);
		return "customer2/checkout";
	}
	@PostMapping("save")
	public String save (Model model,@ModelAttribute("order") Order order,@ModelAttribute("phuongthuc") String phuongthuc) {
		System.out.println(order.getEmail());
		Long accountid=(Long) session.getAttribute("accountid");
		List<CartItem> listci=cartItemService.findCartItem(accountid);
//		cartItemService.DeleteCartItem(accountid);
		order.setOrderDate(new Date());
		List<CartItem> list=cartItemService.findCartItem(accountid);
		double amount=0;
		for(CartItem c: list) {
			amount+=c.getProduct().getUnitPrice()*c.getQuantity();
		}
		order.setAmount(amount);
		Account acc=new Account();
		acc.setId(accountid);
		order.setAccount(acc);
		order.setPhuongthuc(phuongthuc);
//		order.setEmail();
		orderService.save(order);
		Long orderId=order.getOrderId();
		for(CartItem ci:listci) {
			
			OrderDetail od=new OrderDetail();
			od.setQuantity(ci.getQuantity());
			od.setOrder(order);
			od.setProduct(ci.getProduct());
			Product p=ci.getProduct();
			p.setQuantity(p.getQuantity()-ci.getQuantity());
			orderDetailService.save(od);
			cartItemService.delete(ci);
		}
		model.addAttribute("mes","Order is Saved");
		return "forward:/customer/home";
	}
	@RequestMapping("payment")
	public ModelAndView checkout(ModelMap model, @ModelAttribute("order") Order order) {
		System.out.println(order.getEmail());
		model.addAttribute("order", order);
		return new ModelAndView("customer2/payment",model);
	}
}
