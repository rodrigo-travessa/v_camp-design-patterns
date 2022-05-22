package client;

import java.util.Scanner;

import entities.Order;

public class Sale {
	
	 public Order order = new Order();
	
	public Scanner sc = new Scanner(System.in);
	
	public String option = "n";	
	
	{ sale: {
		while (!option.toLowerCase().equals("c") || !option.toLowerCase().equals("f") ) {

			switch(option) {

			case "a":

				System.out.println("Type the Product's SKU:");
				int prodSKU = sc.nextInt();

				System.out.println("How many of them you want?");
				int prodQuantity = sc.nextInt();

				order.cart.verifyQuantityAndAddItems(prodSKU, prodQuantity);
				option ="n";

				break;

			case "r":

				System.out.println("Type the Product's SKU:");
				prodSKU = sc.nextInt();

				System.out.println("How many of them you want?");
				prodQuantity = sc.nextInt();

				order.cart.removeItemsAndAdjustInventory(prodSKU, prodQuantity);

				option = "n";
				break;

			case "n":
				System.out.println("Current Cart");
				order.cart.ItemsInCart.forEach(x -> System.out.println("SKU: "+ x.SKU + " Quantity:"+ x.quantityInCart+"\n"));

				System.out.println("\n How would you wish to proceed?");
				System.out.println("a: Add items to cart, r : Remove items from cart, c: Cancel order f:Finish Order");
				option = sc.next().toLowerCase();
				break;

			case "c":
				break sale;

			case "f":
				break sale;

			default:
				option = "n";
			}
		}
	}
	
	order.updateShipping();

	}
}
