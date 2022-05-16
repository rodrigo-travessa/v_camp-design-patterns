package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import abstracts.Products;

public class ProductInventory {


	private static final ProductInventory productInventory = new ProductInventory();

	public List<Products> Inventory = new ArrayList<Products>();

	
	public static ProductInventory getInstance() {
		return productInventory;
	}


	public int getProductQuantityByInstance(Products product) {
		
	Stream<Products> stream = Inventory.stream().filter(prod -> prod.equals(product));
	return stream.toList().get(0).StockQuantity;
	}
	
	
	
	public int getProductQuantityBySKU(int sku) {
		
		Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
		return stream.toList().get(0).StockQuantity;
		}
	
	public int getProductQuantityReservedBySKU(int sku) {

		Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
		return stream.toList().get(0).ReservedQuantity;
	}
	
	public void removeProductFromStock(int sku, int quantity) {
		
		if (Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0).StockQuantity >= quantity) {
		Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
		stream.toList().get(0).StockQuantity -= quantity;
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	public void addProductsToStock(int sku, int quantity) {
		
		Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
		stream.toList().get(0).StockQuantity += quantity;
	}
	
	public void addProductsToReserve(int sku, int quantity) {
		
		Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
		stream.toList().get(0).ReservedQuantity += quantity;
		
	}
	
	public void removeProductFromReserved(int sku, int quantity) {

		if (Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0).ReservedQuantity >= quantity) {
			Stream<Products> stream = Inventory.stream().filter(prod -> prod.SKU == sku);
			stream.toList().get(0).ReservedQuantity -= quantity;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

}
