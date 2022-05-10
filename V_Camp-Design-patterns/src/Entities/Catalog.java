package Entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Products;

public class Catalog {
	
	public List<Products> catalogOfProducts = new ArrayList<Products>();
	
	public List<Products> getAllProducts() {			
		
		return catalogOfProducts;
		
	}
	
}
