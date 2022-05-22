package client;

import java.util.Collections;
import java.util.Scanner;

import abstracts.Products;
import builders.BoatBuilder;
import builders.BookBuilder;
import builders.MonitorBuilder;
import builders.ShirtBuilder;
import entities.BackOffice;
import entities.Catalog;
import entities.Order;
import entities.OrderList;
import entities.ProductInventory;
import enums.OrderStatus;
import products.Boat;
import products.Book;
import products.Monitor;
import products.Shirt;

public class Client {
	
	
	public static void main(String[] args) throws Exception {
		
		BoatBuilder boatBuilder = new BoatBuilder();
		boatBuilder.setSKU(1).setPrice(10000).setWeight(1000);
		boatBuilder.setStockQuantity(10).setReservedQuantity(0);
		boatBuilder.setEnginePower(150).setSizeinFeet(30);
		Boat boat = boatBuilder.build();
		
		BookBuilder bookBuilder = new BookBuilder();
		bookBuilder.setSKU(2).setPrice(60).setWeight(0.5);
		bookBuilder.setStockQuantity(10).setReservedQuantity(0);
		bookBuilder.setAuthor("Gergo R.R. Martin").setNumberOfPages(650);
		Book book = bookBuilder.build();
		
		ShirtBuilder shirtBuilder = new ShirtBuilder();
		shirtBuilder.setSKU(3).setPrice(400).setWeight(0.2);
		shirtBuilder.setStockQuantity(10).setReservedQuantity(0);
		shirtBuilder.setBrand("Lacoste").setColor("Red");
		Shirt shirt = shirtBuilder.build();
		
		MonitorBuilder monitorBuilder = new MonitorBuilder();
		monitorBuilder.setSKU(4).setPrice(3500).setWeight(3);
		monitorBuilder.setStockQuantity(10).setReservedQuantity(0);
		monitorBuilder.setSizeInInches(31).setScreenResolution("Full HD");
		Monitor monitor = monitorBuilder.build();
		
		Catalog catalog = new Catalog();
		catalog.catalogOfProducts.add(shirtBuilder.getProduct());		
		catalog.catalogOfProducts.add(boatBuilder.getProduct());	
		catalog.catalogOfProducts.add(monitorBuilder.getProduct());
		catalog.catalogOfProducts.add(bookBuilder.getProduct());
		
		Collections.addAll(ProductInventory.getInstance().Inventory, boat, shirt, book, monitor);
		
		BackOffice backOffice = new BackOffice();
		OrderList.getInstance().subscribe(backOffice);
		Scanner scanner = new Scanner(System.in);
		
		
		
		System.out.println("Welcome");
		System.out.println("These are our Products:");
		
		for (Products prod : ProductInventory.getInstance().Inventory) {
			System.out.println(prod.toString());
		}
				
		Sale sale = new Sale();
		
		if (sale.option.toLowerCase().equals("c")) {
			sale.order.toCancelled();
			System.out.println("Order Canceled. do you wish to place a new order? Y/N");
			if (scanner.next().toLowerCase().equals("y")) {
				
				sale = new Sale();
			}
			
		} else {
			System.out.println("Proceeding to Payment");
			System.out.println("Your Order ID is: "+ sale.order.OrderID);
			System.out.println("The Shipping Price is "+ sale.order.shippingPrice);
			System.out.println("The Shipping Method is "+ sale.order.shipping.description());
			System.out.println("The Total Price is " + sale.order.totalPrice);
			sale.order.toPaid();
		}
			
		System.out.println("End of Program");
	}
}
