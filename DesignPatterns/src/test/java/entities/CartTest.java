package entities;

import java.util.Collections;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import abstracts.Products;
import builders.BoatBuilder;
import builders.BookBuilder;
import products.Boat;
import products.Book;

public class CartTest {

	
	@BeforeClass
	public static void setup() {
		
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
		
		Collections.addAll(ProductInventory.getInstance().Inventory, boat, book);
	}
	
	@After
	public void resetInventory() {
		for (Products prod : ProductInventory.getInstance().Inventory) {
			prod.StockQuantity = 10;
			prod.ReservedQuantity = 0;
			prod.CartQuantity = 0;
		}
	}
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void addingItemsToCart() throws Exception {
		Cart cart = new Cart();

		cart.addItems(1, 1);
			
		error.checkThat(cart.getHowManyProductsInCart(), CoreMatchers.is(1));
		error.checkThat(cart.getPrice(), CoreMatchers.is(10000.0));
		error.checkThat(cart.getWeight(), CoreMatchers.is(1000.0));
		
		}
	
	@Test
	public void addingMoreItemsThatHaveInInventory() throws Exception {
		Cart cart = new Cart();
		
		cart.addItems(1, 13);
		
	}
}
