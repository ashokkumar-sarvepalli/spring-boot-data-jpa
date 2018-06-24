package learning.springboot.orders.service;

import org.springframework.stereotype.Component;

import learning.springboot.orders.domain.Order;
import learning.springboot.orders.util.OrderUtil;

@Component
public class OrderService {

	public Order createOrder(Order order) {
		
		Order orderDO = new Order();
		orderDO.setOrderid(OrderUtil.generateUUIDAsString());
		
		
		// find customer exists.
		// find item exists.
		
		// place the order;
		
		return null;
	}

}
