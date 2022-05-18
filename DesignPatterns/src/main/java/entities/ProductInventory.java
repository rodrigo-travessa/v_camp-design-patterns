package entities;

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

	private Products getProduct(int sku) {
		return Inventory.stream().filter(prod -> prod.SKU == sku).toList().get(0);
	}
	
	public int getProductQuantityBySKU(int sku) {

		return getProduct(sku).StockQuantity;
		
	}

	public int getReservedQuantityBySKU(int sku) {
		
		return getProduct(sku).ReservedQuantity;
	}

	public void addProductsToStock(int sku, int quantity) {
		
		getProduct(sku).StockQuantity += quantity;
		
	}

	public void removeProductFromStock(int sku, int quantity) throws Exception {

		if (getProduct(sku).StockQuantity >= quantity) {
			
			getProduct(sku).StockQuantity -= quantity;	
			
		} else {
			
			throw new Exception("Not enought of this product in stock");
		}

	}


	public void addProductsToReserve(int sku, int quantity) {

		getProduct(sku).ReservedQuantity += quantity;;

	}

	public void removeProductFromReserve(int sku, int quantity) throws Exception {

		if (getProduct(sku).ReservedQuantity >= quantity) {
			
			getProduct(sku).ReservedQuantity -= quantity ;

		} else {
			
			throw new Exception("Not enought of this product in reserve");
			
		}

	}

}

