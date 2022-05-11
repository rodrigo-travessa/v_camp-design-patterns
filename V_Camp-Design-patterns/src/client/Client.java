package client;

import Builders.BoatBuilder;
import Builders.BookBuilder;
import Builders.MonitorBuilder;
import Builders.ShirtBuilder;
import Entities.Cart;
import Entities.Catalog;
import Entities.ProductInventory;
import Products.Boat;
import Products.Book;
import Products.Monitor;
import Products.Shirt;

public class Client {

	public static void main(String[] args) {

		
		ProductInventory InventoryRepo = ProductInventory.getInstance();
		Catalog catalog = new Catalog();
		
		Shirt shirtA = new Shirt(2, 2.0, 3.0, "Red", "Brand", 10, 5);
		
		ShirtBuilder shirtBuilder = new ShirtBuilder();
			shirtBuilder.setPrice(350.0d);
			shirtBuilder.setSKU();
			shirtBuilder.setWeight(1.0d);
			shirtBuilder.setBrand("Lacoste");
			shirtBuilder.setColor("Blue");
			shirtBuilder.setReservedQuantity(0);
			shirtBuilder.setStockQuantity(10);
			Shirt shirt = shirtBuilder.build();
		
		BoatBuilder boatBuilder = new BoatBuilder();
			boatBuilder.setPrice(32000.0d);
			boatBuilder.setWeight(1550.0d);
			boatBuilder.setSKU();
			boatBuilder.setEnginePower(150);
			boatBuilder.setSizeinFeet(32);
			boatBuilder.setReservedQuantity(0);
			boatBuilder.setStockQuantity(10);
			Boat boat = boatBuilder.build();
		
		MonitorBuilder monitorBuilder = new MonitorBuilder();
			monitorBuilder.setPrice(2500.0);
			monitorBuilder.setWeight(2.5);
			monitorBuilder.setSKU();
			monitorBuilder.setScreenResolution("1920x1368");
			monitorBuilder.setSizeInInches(28);
			monitorBuilder.setReservedQuantity(0);
			monitorBuilder.setStockQuantity(10);
			Monitor monitor = monitorBuilder.build();
		
		BookBuilder bookBuilder = new BookBuilder();
			bookBuilder.setPrice(69.90);
			bookBuilder.setWeight(0.5);
			bookBuilder.setSKU();
			bookBuilder.setAuthor("Patrick Roffus");
			bookBuilder.setNumberOfPages(680);
			bookBuilder.setReservedQuantity(0);
			bookBuilder.setStockQuantity(10);
			Book book = bookBuilder.build();
			
		
		
		catalog.catalogOfProducts.add(shirtBuilder.getProduct());		
		catalog.catalogOfProducts.add(boatBuilder.getProduct());	
		catalog.catalogOfProducts.add(monitorBuilder.getProduct());
		catalog.catalogOfProducts.add(bookBuilder.getProduct());	
		
		InventoryRepo.Inventory.add(shirtBuilder.getProduct());								
		InventoryRepo.Inventory.add(boatBuilder.getProduct());
		InventoryRepo.Inventory.add(monitorBuilder.getProduct());
		InventoryRepo.Inventory.add(bookBuilder.getProduct());
		
		System.out.println("Hello World!!");
		
		Cart cart = new Cart();
		
		System.out.println(InventoryRepo.getProductQuantityBySKU(1));
		InventoryRepo.removeProductFromStock(1, 7);
		System.out.println(InventoryRepo.getProductQuantityBySKU(1));
		
		
		
	}
	
	
	
	
	
}
