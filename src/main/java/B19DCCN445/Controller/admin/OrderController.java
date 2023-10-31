package B19DCCN445.Controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import B19DCCN445.domain.Order;
import B19DCCN445.domain.OrderDetail;
import B19DCCN445.model.OrderDTO;
import B19DCCN445.service.OrderDetailService;
import B19DCCN445.service.OrderService;



@Controller
@RequestMapping("admin/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	@RequestMapping()
	public String order(Model model) {
		List<Order>list=orderService.findAll();
		List<OrderDTO>listdto=new ArrayList<OrderDTO>();
		
		for(Order o: list) {
			OrderDTO odto=new OrderDTO();
			BeanUtils.copyProperties(o, odto);
			List<OrderDetail> listod= orderDetailService.findByOrderId(o.getOrderId());
			String listorderdetail="";
			for(OrderDetail od: listod) {
				listorderdetail+=od.getProduct().getName()+":"+od.getQuantity()+"  |  ";
			}
			System.out.println(listorderdetail);
			odto.setListorderdetail(listorderdetail);
			listdto.add(odto);
		}
		model.addAttribute("orders",listdto);
		return "admin/orders/Order";

	}
}
