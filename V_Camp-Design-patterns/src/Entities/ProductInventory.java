package Entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Products;

public class ProductInventory {


	private static final ProductInventory productInventory = new ProductInventory();
	
	public List<Products> Inventory = new ArrayList<Products>();
	
	
	private ProductInventory() {}

	public static ProductInventory getInstance() {
		return productInventory;
	}

	public int getProductQuantity(Products product) {
		
		int count = 0;
		
		for (Products prod : Inventory) {
			if (prod == product) {
				count++;
			}else {
				
			}
		}		
		return count;
	}







}
