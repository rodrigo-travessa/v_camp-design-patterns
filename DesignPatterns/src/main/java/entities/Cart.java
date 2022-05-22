package entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Products;
import products.Item;

public class Cart  {
	
	
	public double TotalPrice = 0;
	public double TotalWeight = 0;
	
	
	
	ProductInventory StoreInventory = ProductInventory.getInstance();
	
	
	public List<Item> ItemsInCart = new ArrayList<Item>();
	 
	public void addItems(int sku, int quantity) {
		
		if(StoreInventory.checkIfSkuExists(sku) && quantity > 0) {
			StoreInventory.removeProductFromStock(sku, quantity);
			StoreInventory.addProductsToReserve(sku, quantity);
			ItemsInCart.add(new Item(StoreInventory.getProduct(sku).clone().SKU, quantity));
		} else {
			System.out.println("Invalid SKU or Invalid Quantity.");
		}
		
	}
	
	
	
	public void removeItemsAndAdjustInventory(int sku, int quantity) {
				
		int quantityToBeRemoved = 0;
		
		if (StoreInventory.checkIfSkuExists(sku) && quantity > 0) {
			if( ItemsInCart.stream().filter(item -> item.SKU == sku).count() > 0) {

				if (getProductQuantityInCartBySku(sku) <= quantity) {
					quantityToBeRemoved = getProductQuantityInCartBySku(sku);
					ItemsInCart.remove(getProductDataInCartBySku(sku));
				} else {
					quantityToBeRemoved = quantity;
					getProductDataInCartBySku(sku).quantityInCart -= quantity;
				}
				StoreInventory.removeProductFromReserve(sku, quantityToBeRemoved);
				StoreInventory.addProductsToStock(sku, quantityToBeRemoved);
			} else {
				System.out.println("The Cart doesn't have any items that match this SKU");
			}

		} else {
			System.out.println("Invalid SKU or Negative Quantity");
		}
	}
	
	public double getWeight() {
		TotalWeight = 0;
		for (Item item : ItemsInCart) {
			TotalWeight += getProductData(item.SKU).Weight * item.quantityInCart;
		}
		return TotalWeight;
	}
	
	public double getPrice() {
		TotalPrice = 0;
		for (Item item : ItemsInCart) {
			TotalPrice += getProductData(item.SKU).Price * item.quantityInCart;
		}
		return TotalPrice;		
	}

	public List<Products> getProducts() {
		// Here i could return either a List<Products> or a List<Items>;
		List<Products> list = new ArrayList<Products>();
		for (Item item : ItemsInCart) {
			list.add(getProductData(item.SKU));
		}
		return list;
	}
	
	public int getHowManyProductsInCart() {
		int currentCount = 0;
		for (Item item : ItemsInCart) {
			currentCount += item.quantityInCart;
		}
		return currentCount;
	}
	
	public void verifyQuantityAndAddItems(int ProdSKU, int ProdQuantity) {
		
		if(ProdQuantity > 0) {
			if (StoreInventory.checkIfSkuExists(ProdSKU)) {
				if (StoreInventory.verifyEnoughStock(ProdSKU, ProdQuantity)) {
					this.addItems(ProdSKU, ProdQuantity);
				} else {
					System.out.println("Not Enough Items in stock");
					System.out.println("There are only " + this.getProductData(ProdSKU).getStockQuantity() + " in stock");
				}
			}else {
				System.out.println("This SKU doesn't exist");
			}
		} else {
			System.out.println("Can't add negative Quantities");
		}
	}	


	/*******************************************************************************************************/
	
	public Products getProductData(int sku) {
		if (StoreInventory.checkIfSkuExists(sku)) {
			return StoreInventory.Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0);
		} else {
			return null;
		}
	}
	
	public Item getProductDataInCartBySku(int sku) {
		if (StoreInventory.checkIfSkuExists(sku)) {
			if(verifyItemExistsInCart(sku)) {
				return ItemsInCart.stream().filter(x -> x.SKU == sku).toList().get(0);
			} else { return null;}
		} else {return null;} 
	}

	public int getProductQuantityInCartBySku(int sku) {
		if (StoreInventory.checkIfSkuExists(sku)) {
			if (verifyItemExistsInCart(sku)) {
				return ItemsInCart.stream().filter(prod -> prod.SKU == sku).toList().get(0).quantityInCart;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	public boolean verifyItemExistsInCart(int sku) {
		return ItemsInCart.stream().filter(item -> item.SKU == sku).count() > 0;
	}
	
}

	

