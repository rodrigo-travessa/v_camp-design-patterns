package entities;

import enums.OrderStatus;
import interfaces.IShipping;
import products.Item;

public class Order {
	
	public int OrderID;
	public Cart cart = new Cart();
	public IShipping shipping;
	public double shippingPrice;
	public double totalPrice;
	public OrderStatus orderStatus = OrderStatus.Pending;
	
	public Order() {
		OrderList.getInstance().ListOfOrders.add(this);
		OrderID = OrderList.getInstance().ListOfOrders.size();
	}
	
	public void updateShipping() {
		ShippingFactory shippingfact = new ShippingFactory();
		shipping = shippingfact.getShipping(cart.getWeight());
		shippingPrice = shipping.shipingPrice(cart.getPrice(), cart.getHowManyProductsInCart());
		totalPrice = shippingPrice + cart.getPrice();
		OrderList.getInstance().renderOrderList(this.OrderID);
	}
	
	public void toPaid() {
		this.orderStatus = OrderStatus.Paid;
		for (Item prod : this.cart.ItemsInCart) {
			ProductInventory.getInstance().removeProductFromReserve(prod.SKU, prod.quantityInCart);
		}
		OrderList.getInstance().renderOrderList(this.OrderID);
	}
	
	public void toShipped() {
		this.orderStatus = OrderStatus.Shipped;
		OrderList.getInstance().renderOrderList(this.OrderID);	
	}

	public void toCompleted() {
		this.orderStatus = OrderStatus.Completed;
		OrderList.getInstance().renderOrderList(this.OrderID);	
	}

	public void toCancelled() {
		
		this.orderStatus = OrderStatus.Cancelled;
		OrderList.getInstance().renderOrderList(this.OrderID);
		if(cart.ItemsInCart.size()>0) {

			if(cart.ItemsInCart.size()>1) {

				for (Item item : cart.ItemsInCart) {
					cart.removeItemsAndAdjustInventory(item.SKU, item.quantityInCart);
				}
			}else {
				cart.removeItemsAndAdjustInventory(cart.ItemsInCart.get(0).SKU, cart.ItemsInCart.get(0).SKU);
			}
		}
		
//		if(this.cart.getHowManyProductsInCart() >= 1) {
//			System.out.println("Degub 1");
//			for (Item item : cart.ItemsInCart) {
//				this.cart.removeItemsAndAdjustInventory(item.SKU, item.quantityInCart);
//			}
//		}
	}
}
