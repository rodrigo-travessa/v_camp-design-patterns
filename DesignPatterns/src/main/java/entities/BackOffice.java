package entities;

import enums.OrderStatus;
import interfaces.IObservers;

public class BackOffice implements IObservers {

	@Override
	public void ping(int ID) {
		System.out.println("Getting Info About Order: "+ ID + ";");
		if (OrderList.getInstance().ListOfOrders.stream()
				.filter(order -> order.OrderID == ID).toList().get(0)
				.orderStatus == OrderStatus.Paid) {
			
			System.out.println("Order "+ ID +" was paid, and is being shipped");
			OrderList.getInstance().ListOfOrders.stream()
			.filter(order -> order.OrderID == ID).toList().get(0).toShipped();
			System.out.println("Order "+ ID+ " was shipped and is now Completed");
			OrderList.getInstance().ListOfOrders.stream()
			.filter(order -> order.OrderID == ID).toList().get(0).toCompleted();;
		}
	}

}
