package entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Products;

public class Cart  {
	
	
	public double TotalPrice = 0;
	public double TotalWeight = 0;
	
	
	
	ProductInventory StoreInventory = ProductInventory.getInstance();
	
	List<Products> ProductsInCart = new ArrayList<Products>();
	
	
	public void addItems(int sku, int quantity) throws Exception {
		
		StoreInventory.removeProductFromStock(sku, quantity);
		StoreInventory.addProductsToReserve(sku, quantity);
		
		ProductsInCart.add(StoreInventory.getProduct(sku).clone());
		getProductData(sku).CartQuantity = quantity;
		
	}
	
	
	public boolean removeItems(int sku, int quantity) throws Exception {
		
		if (getProductData(sku).CartQuantity >= quantity) {
			StoreInventory.addProductsToStock(sku, quantity);
			getProductData(sku).CartQuantity -= quantity;
			return true;
		}	else {
			System.out.println("You tried to remove "+ quantity+" items but the cart only has "+ getProductData(sku).CartQuantity );
			return false;
		}
			
	}
	
	
	public double getWeight() {
		TotalWeight = 0;
		ProductsInCart.forEach(productInCart -> TotalWeight += (productInCart.getWeight() * productInCart.CartQuantity));
		return TotalWeight;
	}
	
	public double getPrice() {
		TotalPrice = 0;
		ProductsInCart.forEach(productInCart -> TotalPrice += (productInCart.getPrice() * productInCart.CartQuantity));
		return TotalPrice;		
	}

	public List<Products> getProducts() {
		
		return ProductsInCart ;
	}
	
	public int getHowManyProductsInCart() {
		int currentCount = 0;
		for (Products prod : ProductsInCart) {
			currentCount += prod.CartQuantity;
		}
		return currentCount;
	}

	public Products getProductData(int sku) {
		return ProductsInCart.stream().filter(prod -> prod.SKU == sku).toList().get(0);
	}
	

	

}

	

