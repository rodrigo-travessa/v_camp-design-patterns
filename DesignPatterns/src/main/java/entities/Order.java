package entities;

import enums.OrderStatus;
import interfaces.IShipping;

public class Order {
	
	public Cart cart = new Cart();
	public IShipping shipping;
	public OrderStatus orderStatus = OrderStatus.Pending;
	
	public Order() {}
	
	
	
	public void toPaid() {
		this.orderStatus = OrderStatus.Paid;
	}
	public void toShipped() {
		this.orderStatus = OrderStatus.Shipped;
	}
	public void toCompleted() {
		this.orderStatus = OrderStatus.Completed;
	}
	public void toCancelled() {
		this.orderStatus = OrderStatus.Cancelled;
	}

}
