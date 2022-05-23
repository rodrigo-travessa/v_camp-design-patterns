package entities;

import java.util.Collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import builders.BoatBuilder;
import enums.OrderStatus;
import products.Boat;

public class OrderTest {
	
	@BeforeClass	
	public static void resetSetup() {
		ProductInventory.getInstance().Inventory.removeAll(ProductInventory.getInstance().Inventory);
		OrderList.getInstance().ListOfOrders.removeAll(OrderList.getInstance().ListOfOrders);
	}
	

	
	@Test
	public void creatingAnOrder() {
		Order order = new Order();
		
		Assert.assertTrue(order.cart != null);
		Assert.assertTrue(order.OrderID == 1);
		Assert.assertTrue(OrderList.getInstance().ListOfOrders.contains(order));
		Assert.assertTrue(order.orderStatus == OrderStatus.Pending);
		Assert.assertTrue(order.shippingPrice == 0 && order.shipping == null);
	}
	
	@Test
	public void updateShipping() {
		
		BoatBuilder boatBuilder = new BoatBuilder();
		boatBuilder.setSKU(1).setPrice(1000).setWeight(1000);
		boatBuilder.setStockQuantity(10).setReservedQuantity(0);
		boatBuilder.setEnginePower(150).setSizeinFeet(30);
		Boat boat = boatBuilder.build();
		
		Collections.addAll(ProductInventory.getInstance().Inventory, boat);
		
		Order order = new Order();
		
		order.updateShipping();
		
		Assert.assertTrue(order.shipping.description() == "Aero");
		Assert.assertTrue(order.cart.getWeight() == 0);
		Assert.assertTrue(order.cart.getPrice() == 0);
		
		order.cart.verifyQuantityAndAddItems(1, 1);
		order.updateShipping();
		
		Assert.assertTrue(order.shipping.description() == "Road");
		Assert.assertTrue(order.shippingPrice == 101.0);
		Assert.assertTrue(order.totalPrice == 1101.0);
		
		
	}
	
	@Test
	public void orderStatusProgression() {
		
		BoatBuilder boatBuilder = new BoatBuilder();
		boatBuilder.setSKU(2).setPrice(1000).setWeight(1000);
		boatBuilder.setStockQuantity(10).setReservedQuantity(0);
		boatBuilder.setEnginePower(150).setSizeinFeet(30);
		Boat boat = boatBuilder.build();
		
		BoatBuilder boatBuilder2 = boatBuilder.setSKU(3);
		Boat boat2 = boatBuilder2.build();
		
		Collections.addAll(ProductInventory.getInstance().Inventory, boat);
		
		Order order = new Order();
		order.cart.verifyQuantityAndAddItems(2, 5);
		
		order.toShipped();
		Assert.assertTrue(order.orderStatus == OrderStatus.Shipped);
		order.toCompleted();
		Assert.assertTrue(order.orderStatus == OrderStatus.Completed);
		order.toPaid();
		Assert.assertTrue(order.orderStatus == OrderStatus.Paid);
		order.toCancelled();
		Assert.assertTrue(order.orderStatus == OrderStatus.Cancelled);
		
		order.cart.verifyQuantityAndAddItems(2, 3);
		order.cart.verifyQuantityAndAddItems(3, 3);
		
		order.toCompleted();
		order.toCancelled();
	}
	

}
