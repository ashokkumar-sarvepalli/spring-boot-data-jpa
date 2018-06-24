package learning.springboot.orders.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="ordersentry")
public class Order {
	
	@Id
	@Column(name="orderid")
	private String orderid;
	
	@OneToOne
	@JoinColumn(name="custid")
	private Customer customer;
	
	@Column(name="totalamount")
	private double totalAmount;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("order")
	private List<OrderItems> itemsList;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
