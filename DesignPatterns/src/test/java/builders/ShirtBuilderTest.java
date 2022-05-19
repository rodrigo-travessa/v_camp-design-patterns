package builders;

import org.junit.Assert;
import org.junit.Test;

import products.Shirt;

public class ShirtBuilderTest {

	@Test
	public void builderWorkingProperly() {
		
		ShirtBuilder shirtBuilder = new ShirtBuilder();
		shirtBuilder.setSKU(1).setPrice(10000).setWeight(1000);
		shirtBuilder.setStockQuantity(10).setReservedQuantity(0);
		shirtBuilder.setBrand("Lacoste").setColor("Red");
		Shirt shirt = shirtBuilder.build();
		
		Assert.assertTrue(shirt.getSKU() == 1);
		Assert.assertTrue(shirt.getPrice() == 10000);
		Assert.assertTrue(shirt.getWeight() == 1000);
		Assert.assertTrue(shirt.getStockQuantity() == 10);
		Assert.assertTrue(shirt.getReservedQuantity() == 0);
		Assert.assertTrue(shirt.getBrand() == "Lacoste");
		Assert.assertTrue(shirt.getColor() == "Red");
	}
}
