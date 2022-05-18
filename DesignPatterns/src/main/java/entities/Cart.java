package entities;

import java.util.ArrayList;
import java.util.List;

import Shipping.AirShipping;
import Shipping.IShippingInterface;
import Shipping.RoadShipping;
import Shipping.ShippingVehicle;
import abstracts.Products;

public class Cart  {
	
	
	public double TotalPrice = 0;
	public double TotalWeight = 0;
	public ShippingVehicle TransportMethod;
	
	ProductInventory StoreInventory = ProductInventory.getInstance();
	List<Products> ProductsInCart = new ArrayList<Products>();
	
	public void addItems(int sku, int quantity) {
		
		// Should this remove or reserve items from stock?
		
		StoreInventory.removeProductFromStock(sku, quantity);
		StoreInventory.addProductsToReserve(sku, quantity);
		ProductsInCart.add(StoreInventory.Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0));
		ProductsInCart.stream().filter(prod -> prod.SKU == sku).toList().get(0).StockQuantity = quantity;
		
	}
	
	public void removeItems(int sku, int quantity) {
		
		int currentCartQuantity = ProductsInCart.stream().filter(prod -> prod.SKU == sku).toList().get(0).StockQuantity;
		
		if (currentCartQuantity >= quantity) {
			StoreInventory.addProductsToStock(sku, quantity);
		}	else {
			
			throw new UnsupportedOperationException("There isn't enough items in the cart");
		}
			
	}
	
	
	public double getWeight() {
		ProductsInCart.forEach(x -> TotalWeight += (x.getWeight() * x.StockQuantity));
		return TotalWeight;
	}
	
	public double getPrice() {
		ProductsInCart.forEach(x -> TotalPrice += (x.getPrice() * x.StockQuantity));
		return TotalWeight;		
	}

	public List<Products> getProducts() {
		
		return ProductsInCart ;
	}


	public void setShipping() {
		
		IShippingInterface x;

		if (this.getWeight() >= 10) {
			x = new RoadShipping();

		} else {
			x = new AirShipping();

		}

		TransportMethod = x.DefineTransport();

	}

}

	

