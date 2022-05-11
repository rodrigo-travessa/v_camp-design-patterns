package Entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Products;

public class Cart {
	
	
	public double TotalPrice = 0;
	public double TotalWeight = 0;
	
	ProductInventory InventarioCart = ProductInventory.getInstance();
	List<Products> CartList = new ArrayList<Products>();
	
	public void addItem(int sku, int quantity) {
		
		// Should this remove or reserve items from stock?
		
		InventarioCart.removeProductFromStock(sku, quantity);
		CartList.add(InventarioCart.Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0));
		CartList.stream().filter(prod -> prod.SKU == sku).toList().get(0).StockQuantity = quantity;
		
	}
	
	public void removeItem(int sku, int quantity) {
		
		
		
	}
	
	
	public double getCartWeight() {
		CartList.forEach(x -> TotalWeight += (x.getWeight() * x.StockQuantity));
		return TotalWeight;
	}
	
	public double getCartPrice() {
		CartList.forEach(x -> TotalPrice += (x.getPrice() * x.StockQuantity));
		return TotalWeight;		
	}
}
