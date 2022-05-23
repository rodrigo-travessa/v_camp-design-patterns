package productsTest;

import org.junit.Assert;
import org.junit.Test;

import products.Boat;
import products.Monitor;

public class BoatTest {
	
	@Test
	public void cloneTest() {
		Boat boat = new Boat();
		boat.EnginePower = 150;
		boat.SizeInFeet = 30;
		boat.Price = 10.0;
		boat.ReservedQuantity = 0;
		boat.StockQuantity = 10;
		boat.SKU = 1;
		boat.Weight = 1.0;
		
		Boat clonedBoat = boat.clone();
		
		Assert.assertTrue(boat != clonedBoat);
		Assert.assertTrue(boat.getEnginePower() == clonedBoat.getEnginePower());
		Assert.assertTrue(boat.getSizeInFeet() == clonedBoat.getSizeInFeet());
		Assert.assertTrue(boat.getPrice() == clonedBoat.getPrice());
		Assert.assertTrue(boat.getReservedQuantity() == clonedBoat.getReservedQuantity());
		Assert.assertTrue(boat.getStockQuantity() == clonedBoat.getStockQuantity());
		Assert.assertTrue(boat.getSKU() == clonedBoat.getSKU());
		Assert.assertTrue(boat.getWeight() == clonedBoat.getWeight());
	}
	
	@Test
	public void toStringTest() {
		
		Boat boat = new Boat();
		boat.EnginePower = 150;
		boat.SizeInFeet = 30;
		boat.Price = 10.0;
		boat.ReservedQuantity = 0;
		boat.StockQuantity = 10;
		boat.SKU = 1;
		boat.Weight = 1.0;
		
		System.out.println(boat.toString());
		Assert.assertTrue(boat.toString().equals("Boat:SKU: 1 EnginePower:150HP, SizeInFeet:30, Price:10.0, Weight:1.0KGs;"));
	}

}
