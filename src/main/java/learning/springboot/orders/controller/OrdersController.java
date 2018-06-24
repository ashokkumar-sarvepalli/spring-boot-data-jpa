package learning.springboot.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import learning.springboot.orders.domain.Order;
import learning.springboot.orders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody Order order){
		Order orderRepsonse;
		try {
			orderRepsonse = orderService.createOrder(order);
		} catch (Exception ex) {
			learning.springboot.model.Error error = new learning.springboot.model.Error();
			error.setCode(HttpStatus.CONFLICT.name());
			error.setMessage("conflict occured");
			error.setDetails(ex.getMessage());
			return  ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(orderRepsonse);
	}

}
