package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.IObservers;

public class OrderList {
	
	private static final OrderList Orders = new OrderList();
	
	private OrderList() {
	}
	
	public static OrderList getInstance() {
		return Orders;
	}
	
	private int current = 1;
	
	List<Order> ListOfOrders = new ArrayList<Order>();
	
	public int getCurrentCounter() {
		return current;
	}
	
	public void incrementCurrentCounter() {
		current += 1;
	}
	
	public Order getCurrent() {
		return ListOfOrders.get(current-1);
	}
	
	
	public boolean hasNext() {
		return ListOfOrders.size() > current;
	}
	
	public void reset() {
		current = 1;
	}
	
	public void renderOrderList(int orderID) {
		for (IObservers obs : subscribers) {
			obs.ping(orderID);
		}
	}
	
	public List<IObservers> subscribers = new ArrayList<IObservers>();
	
	public void subscribe(IObservers observer) {
		this.subscribers.add(observer);
	}
}
