package client;

import java.lang.reflect.Array;

import Builders.BoatBuilder;
import Builders.BookBuilder;
import Builders.MonitorBuilder;
import Builders.ShirtBuilder;
import Entities.Catalog;
import Entities.ProductInventory;
import Interfaces.IProductBuilder;
import Products.Shirt;

public class Client {

	public static void main(String[] args) {

		
		ProductInventory inventario = ProductInventory.getInstance();
		Catalog catalog = new Catalog();
		
		
		ShirtBuilder shirtBuilder = new ShirtBuilder().withPrice(150.0).withWeight(1.0)
													  .withBrand("Shirt Brand").withColor("Shirt Color");													  
		
		BoatBuilder boatBuilder = new BoatBuilder().withPrice(32000.0d).withWeight(1550.0d)
												   .withEnginePower(150).withSizeInFeet(32);
		
		MonitorBuilder monitorBuilder = new MonitorBuilder().withPrice(2500.0).withWeight(2.5)
															.withScreenResolution("1920x1368").withSizeInInches(28);
		
		BookBuilder bookBuilder = new BookBuilder().withPrice(69.90).withWeight(0.5)
												   .withAuthor("Patrick Roffus").withNumberOfPages(680);
		
		catalog.catalogOfProducts.add(shirtBuilder.build());		
		incomingProducts(shirtBuilder, 10);
		
		catalog.catalogOfProducts.add(boatBuilder.build());		
		incomingProducts(boatBuilder, 10);
		
		catalog.catalogOfProducts.add(monitorBuilder.build());		
		incomingProducts(monitorBuilder, 10);
		
		catalog.catalogOfProducts.add(bookBuilder.build());		
		incomingProducts(bookBuilder, 10);
		
		//	.base(double price, double weight);
		// Criar abstract ou outra interface que aceite um .withBase(Price, Weight) e economize código.
		
		
		
		
		
		System.out.println("Hello World");
		
		
		
		
		
		
		
	}
	
	public static void incomingProducts(IProductBuilder builder, int quantity) {				
		// Add to Inventory		
		for (int i = 0 ; i < quantity ; i++) {			
			ProductInventory.getInstance().addProduct( builder.withSKU().build());			
		}
		
		
	}
	
}
