package builders;

import org.junit.Assert;
import org.junit.Test;

import products.Monitor;

public class MonitorBuilderTest {

	@Test
	public void builderWorkingProperly() {
		
		MonitorBuilder monitorBuilder = new MonitorBuilder();
		monitorBuilder.setSKU(1).setPrice(10000).setWeight(1000);
		monitorBuilder.setStockQuantity(10).setReservedQuantity(0);
		monitorBuilder.setSizeInInches(30).setScreenResolution("Full HD");
		Monitor monitor = monitorBuilder.build();
		
		Assert.assertTrue(monitor.getSKU() == 1);
		Assert.assertTrue(monitor.getPrice() == 10000);
		Assert.assertTrue(monitor.getWeight() == 1000);
		Assert.assertTrue(monitor.getStockQuantity() == 10);
		Assert.assertTrue(monitor.getReservedQuantity() == 0);
		Assert.assertTrue(monitor.getScreenResolution() == "Full HD");
		Assert.assertTrue(monitor.getSizeInInches() == 30);
		Assert.assertTrue(monitor == monitorBuilder.getProduct());

	}
}