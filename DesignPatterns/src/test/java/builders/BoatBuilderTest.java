package builders;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import products.Boat;

public class BoatBuilderTest {
	
	
	@Test
	public void builderWorkingProperly() {
		
		BoatBuilder boatBuilder = new BoatBuilder();
		boatBuilder.setSKU(1).setPrice(10000).setWeight(1000);
		boatBuilder.setStockQuantity(10).setReservedQuantity(0);
		boatBuilder.setEnginePower(150).setSizeinFeet(30);
		Boat boat = boatBuilder.build();
		
		Assert.assertTrue(boat.getSKU() == 1);
		Assert.assertTrue(boat.getPrice() == 10000);
		Assert.assertTrue(boat.getWeight() == 1000);
		Assert.assertTrue(boat.getStockQuantity() == 10);
		Assert.assertTrue(boat.getReservedQuantity() == 0);
		Assert.assertTrue(boat.getEnginePower() == 150);
		Assert.assertTrue(boat.getSizeInFeet() == 30);
		Assert.assertTrue(boat == boatBuilder.getProduct());

		
	}
	
	
}
