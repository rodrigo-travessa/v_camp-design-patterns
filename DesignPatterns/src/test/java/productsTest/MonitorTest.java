package productsTest;

import org.junit.Assert;
import org.junit.Test;

import products.Monitor;
import products.Shirt;

public class MonitorTest {
	
	@Test
	public void cloneTest() {
		Monitor monitor = new Monitor();
		monitor.ScreenResolution = "4k";
		monitor.SizeInInches = 32;
		monitor.Price = 10.0;
		monitor.ReservedQuantity = 0;
		monitor.StockQuantity = 10;
		monitor.SKU = 1;
		monitor.Weight = 1.0;
		
		Monitor clonedMonitor = monitor.clone();
		
		Assert.assertTrue(monitor != clonedMonitor);
		Assert.assertTrue(monitor.getScreenResolution() == clonedMonitor.getScreenResolution());
		Assert.assertTrue(monitor.getSizeInInches() == clonedMonitor.getSizeInInches());
		Assert.assertTrue(monitor.getPrice() == clonedMonitor.getPrice());
		Assert.assertTrue(monitor.getReservedQuantity() == clonedMonitor.getReservedQuantity());
		Assert.assertTrue(monitor.getStockQuantity() == clonedMonitor.getStockQuantity());
		Assert.assertTrue(monitor.getSKU() == clonedMonitor.getSKU());
		Assert.assertTrue(monitor.getWeight() == clonedMonitor.getWeight());
	}
	
	@Test
	public void toStringTest() {
		
		Monitor monitor = new Monitor();
		monitor.ScreenResolution = "4k";
		monitor.SizeInInches = 32;
		monitor.Price = 10.0;
		monitor.ReservedQuantity = 0;
		monitor.StockQuantity = 10;
		monitor.SKU = 1;
		monitor.Weight = 1.0;
		
		System.out.println(monitor.toString());
		Assert.assertTrue(monitor.toString().equals("Monitor:SKU: 1 Size:32\", Resolution:4k, Price:10.0, Weight:1.0KGs;"));
	}

}
