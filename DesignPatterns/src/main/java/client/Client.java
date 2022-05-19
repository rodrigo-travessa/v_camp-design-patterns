package client;

import java.util.Collections;

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
		shirtBuilder.setSKU(2).setPrice(400).setWeight(0.2);
		shirtBuilder.setStockQuantity(10).setReservedQuantity(0);
		shirtBuilder.setBrand("Lacoste").setColor("Red");
		Shirt shirt = shirtBuilder.build();
		
		MonitorBuilder monitorBuilder = new MonitorBuilder();
		monitorBuilder.setSKU(3).setPrice(3500).setWeight(3);
		monitorBuilder.setStockQuantity(10).setReservedQuantity(0);
		monitorBuilder.setSizeInInches(31).setScreenResolution("Full HD");
		Monitor monitor = monitorBuilder.build();
		
		Catalog catalog = new Catalog();
		catalog.catalogOfProducts.add(shirtBuilder.getProduct());		
		catalog.catalogOfProducts.add(boatBuilder.getProduct());	
		catalog.catalogOfProducts.add(monitorBuilder.getProduct());
		catalog.catalogOfProducts.add(bookBuilder.getProduct());
		
		Collections.addAll(ProductInventory.getInstance().Inventory, boat, shirt, book, monitor);
		
		for (Products prod : ProductInventory.getInstance().Inventory ) {
			System.out.println(prod.toString());
		}
		
		BackOffice backOffice = new BackOffice();
		OrderList.getInstance().subscribe(backOffice);
		
		Order order = new Order();
		
		order.cart.addItems(1, 4);
		order.cart.removeItems(1, 2);
		order.cart.addItems(3, 14);
		order.updateShipping();
		System.out.println(order.shippingPrice +" "+ order.totalPrice + order.shipping.description());
		
		order.cart.removeItems(1, 5);
		
		System.out.println("End");
		
		
		
		
		
		
		
		
		
		
	}

}
