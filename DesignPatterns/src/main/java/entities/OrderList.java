package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
	
	private static final OrderList Orders = new OrderList();
	
	private OrderList() {}
	
	public OrderList getInstance() {
		return Orders;
	}
	
	private int current = 0;
	
	List<Order> ListOfOrders = new ArrayList<Order>();
	
	
	public Order getCurrent() {
		return ListOfOrders.get(current);
	}
	
	public boolean hasNext() {
		return ListOfOrders.size() > current;
	}
	
	public void reset() {
		current = 0;
	}
}
