package entities;

import org.junit.Assert;
import org.junit.Test;

import builders.ShirtBuilder;
import products.Shirt;

public class CatalogTest {

	
	@Test
	public void catalogCreation() {
		Catalog catalog = new Catalog();
	}
	
	@Test
	public void catalogGetProducts() {
		
		ShirtBuilder shirtBuilder = new ShirtBuilder();
		shirtBuilder.setSKU(3).setPrice(400).setWeight(0.2);
		shirtBuilder.setStockQuantity(10).setReservedQuantity(0);
		shirtBuilder.setBrand("Lacoste").setColor("Red");
		Shirt shirt = shirtBuilder.build();
		
		Catalog catalog = new Catalog();
		catalog.catalogOfProducts.add(shirtBuilder.getProduct());	
		
		Assert.assertTrue(catalog.getAllProducts().get(0) == shirt);
	}
}
