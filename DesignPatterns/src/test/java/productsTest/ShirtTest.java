package productsTest;

import org.junit.Assert;
import org.junit.Test;

import products.Shirt;

public class ShirtTest {
	
	
	@Test
	public void cloneTest() {
		Shirt shirt = new Shirt();
		shirt.Brand = "Teste";
		shirt.Color = "Red";
		shirt.Price = 10.0;
		shirt.ReservedQuantity = 0;
		shirt.StockQuantity = 10;
		shirt.SKU = 1;
		shirt.Weight = 1.0;
		
		Shirt clonedShirt = shirt.clone();
		
		Assert.assertTrue(shirt != clonedShirt);
		Assert.assertTrue(shirt.getBrand() == clonedShirt.getBrand());
		Assert.assertTrue(shirt.getColor() == clonedShirt.getColor());
		Assert.assertTrue(shirt.getPrice() == clonedShirt.getPrice());
		Assert.assertTrue(shirt.getReservedQuantity() == clonedShirt.getReservedQuantity());
		Assert.assertTrue(shirt.getStockQuantity() == clonedShirt.getStockQuantity());
		Assert.assertTrue(shirt.getSKU() == clonedShirt.getSKU());
		Assert.assertTrue(shirt.getWeight() == clonedShirt.getWeight());
	}
	
	@Test
	public void toStringTest() {
		
		Shirt shirt = new Shirt();
		shirt.Brand = "Teste";
		shirt.Color = "Red";
		shirt.Price = 10.0;
		shirt.ReservedQuantity = 0;
		shirt.StockQuantity = 10;
		shirt.SKU = 1;
		shirt.Weight = 1.0;
		
		
		Assert.assertTrue(shirt.toString().equals("Shirt:SKU: 1 Brand:Teste, Color:Red, Price:10.0, Weight:1.0KGs;"));
	}
	

}
