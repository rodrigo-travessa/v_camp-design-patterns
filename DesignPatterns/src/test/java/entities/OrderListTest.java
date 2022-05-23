package entities;

import org.junit.Assert;
import org.junit.Test;

public class OrderListTest {
	
	@Test
	public void orderListIteratorTesting() {
		OrderList.getInstance().ListOfOrders.removeAll(OrderList.getInstance().ListOfOrders);
		Order order1 = new Order();
		Order order2 = new Order();
		
		OrderList ol = OrderList.getInstance();

		Assert.assertTrue(ol.getCurrent().OrderID == 1);
		Assert.assertTrue(ol.hasNext());
		ol.incrementCurrentCounter();
		Assert.assertTrue(ol.getCurrent().OrderID == 2);
		Assert.assertFalse(ol.hasNext());
	}
}
