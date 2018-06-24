package learning.springboot.orders.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="order_items")
public class OrderItems {

	@Id
	@Column(name="id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="orderid")
	private Order order;
	
	@OneToOne
	@Column(name="itemid")
	private Item item;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="amount")
	private double amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
}
