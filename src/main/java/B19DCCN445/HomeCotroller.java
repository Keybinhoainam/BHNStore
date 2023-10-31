package B19DCCN445;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import B19DCCN445.domain.CartItem;
import B19DCCN445.domain.Category;
import B19DCCN445.domain.Product;
import B19DCCN445.model.ProductDTO;
import B19DCCN445.service.CartItemService;
import B19DCCN445.service.CategoryService;
import B19DCCN445.service.ProductService;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
@RequestMapping("")
public class HomeCotroller {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
    private HttpSession session;
	@RequestMapping("/")
	public String redirect(Model model ) {
//		return "redirect:/customer/home";  
		return "home";
	}
	
	@RequestMapping("/customer/home")
	public String home(Model model ) {
//		System.out.println("ok");
		
		List<ProductDTO> listp1=new ArrayList<>();
		List<Product> listp1t=productService.findByCategory1();
		Collections.sort(listp1t, new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) {
            	return -m1.getDiscount()+m2.getDiscount();
            }
        });
		for(int i=0;i<3&&i<listp1t.size();i++) {
			ProductDTO pdt1=new ProductDTO();
			Product p=listp1t.get(i);
			BeanUtils.copyProperties(p, pdt1);
			double primeCost=pdt1.getUnitPrice()+ pdt1.getUnitPrice()* (p.getDiscount()* 0.01);
			pdt1.setPrimeCost(primeCost);
//			System.out.println(pdt1.getUnitPrice() + "   "+primeCost+" "+(double)((p.getDiscount()* 0.01)));
			listp1.add(pdt1);
		}
		
		List<ProductDTO> listp2=new ArrayList<>();
		List<Product> listp2t=productService.findByCategory2();
		Collections.sort(listp2t, new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) {
                return -m1.getDiscount()+m2.getDiscount();
            }
        });
		for(int i=0;i<3&&i<listp2t.size();i++) {
			ProductDTO pdt2=new ProductDTO();
			Product p=listp2t.get(i);
			BeanUtils.copyProperties(p, pdt2);
			double primeCost=p.getUnitPrice()+p.getUnitPrice()* (p.getDiscount()* 0.01);
			pdt2.setPrimeCost(primeCost);
//			System.out.println(pdt2.getUnitPrice() + "   "+primeCost);
			listp2.add(pdt2);
		}
		List<ProductDTO> listp3=new ArrayList<>();
		List<Product> listp3t=productService.findByCategory3();
		Collections.sort(listp3t, new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) {
            	return -m1.getDiscount()+m2.getDiscount();
            }
        });
		for(int i=0;i<3&&i<listp3t.size();i++) {
			ProductDTO pdt3=new ProductDTO();
			Product p=listp3t.get(i);
			BeanUtils.copyProperties(p, pdt3);
			double primeCost=p.getUnitPrice()+ p.getUnitPrice() * (p.getDiscount()* 0.01);
			pdt3.setPrimeCost(primeCost);
//			System.out.println(pdt3.getUnitPrice() + "   "+primeCost);
			listp3.add(pdt3);
		}
		
		List<ProductDTO> listp4=new ArrayList<>();
		List<Product> listp4t=productService.findAll();
		Collections.sort(listp4t, new Comparator<Product>() {
            @Override
            public int compare(Product m1, Product m2) {
            	return Double.compare(m1.getUnitPrice(), m2.getUnitPrice());
            }
        });
		for(int i=0;i<5&&i<listp4t.size();i++) {
			ProductDTO pdt4=new ProductDTO();
			Product p=listp4t.get(i);
			BeanUtils.copyProperties(p, pdt4);
			double primeCost=p.getUnitPrice()+ p.getUnitPrice() * (p.getDiscount()* 0.01);
			pdt4.setPrimeCost(primeCost);
//			System.out.println(pdt3.getUnitPrice() + "   "+primeCost);
			listp4.add(pdt4);
		}
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("products1",listp1);
		model.addAttribute("products2",listp2);
		model.addAttribute("products3",listp3);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		model.addAttribute("specialOffers",listp4);
		Long accountid=(Long) session.getAttribute("accountid");
		
		model.addAttribute("accountid", accountid);
		return "customer2/index";
	}
	@RequestMapping("/customer/home/loc")
	public String loc(Model model,@ModelAttribute("categoryselect") Long categoryselect, @ModelAttribute("statusselect") String statusselect) {
//		System.out.println("ok");
		
		
		List<Product> listproductselect=productService.findByCondi(categoryselect,statusselect);
//		List<Product> listp=productService.findAll();
		List<Category> listc=categoryService.findAll();
		List<CartItem> listci=cartItemService.findAll();
		model.addAttribute("products",listproductselect);
		model.addAttribute("categories",listc);
		model.addAttribute("cartitems",listci);
		model.addAttribute("productselect",listproductselect);
		Long accountid=(Long) session.getAttribute("accountid");
		model.addAttribute("accountid", accountid);
		
		return "customer/HomeN";
	}
}
