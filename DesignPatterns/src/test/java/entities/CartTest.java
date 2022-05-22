package entities;

import java.util.Collections;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

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
			
		}
	}
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void addingItemsToCart() throws Exception {
		Cart cart = new Cart();

		cart.verifyQuantityAndAddItems(1, 1);
			
		error.checkThat(cart.getHowManyProductsInCart(), CoreMatchers.is(1));
		error.checkThat(cart.getPrice(), CoreMatchers.is(10000.0));
		error.checkThat(cart.getWeight(), CoreMatchers.is(1000.0));
		
		}
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void addingMoreItemsThatHaveInInventory() {
		
		Cart cart = new Cart();
		
		
		cart.verifyQuantityAndAddItems(1, 13);
		
		Assert.assertTrue(cart.getHowManyProductsInCart() == 0);
		Assert.assertTrue(cart.ItemsInCart.size() == 0);
		Assert.assertFalse(ProductInventory.getInstance().verifyEnoughStock(1, 13));
	}
	
	@Test
	public void addingItemsThatDontExistToCart() {
		Cart cart = new Cart();
		
		cart.verifyQuantityAndAddItems(5, 3);
	}
	
	@Test
	public void removingItemsFromCart() {
		Cart cart = new Cart();
		
		cart.addItems(1, 10);
		
		Assert.assertTrue(cart.getProductQuantityInCartBySku(1) == 10);
		Assert.assertTrue(cart.StoreInventory.getProductQuantityBySKU(1) == 0);
		
		cart.removeItemsAndAdjustInventory(1, 3);
		
		Assert.assertTrue(cart.getProductQuantityInCartBySku(1) == 7);
		
	}
	
	@Test
	public void removingItemsThatAreNotInTheCart() {
		Cart cart = new Cart();
		
		cart.removeItemsAndAdjustInventory(1, 4);
	}
	
	@Test
	public void removingItemsThatDontExistFromCart() {
		Cart cart = new Cart();
		
		cart.removeItemsAndAdjustInventory(12, 3);
	}
	
	@Test
	public void removingItemsWithExcessiveQuantityAsParameter() {
		Cart cart = new Cart();
		
		cart.verifyQuantityAndAddItems(1, 10);
		cart.removeItemsAndAdjustInventory(1, 40);
		
		Assert.assertTrue(cart.getProductQuantityInCartBySku(1) == 0);
		Assert.assertTrue(cart.StoreInventory.getProductQuantityBySKU(1) == 10);
	}
	
	@Test
	public void addingNegativeQuantitiesOfItems() {
		Cart cart = new Cart();
		cart.verifyQuantityAndAddItems(1, -3);
		System.out.println(cart.TotalWeight + " " + cart.TotalPrice  + " " + cart.StoreInventory.getProductQuantityBySKU(1));
	}
	
	@Test 
	public void removingNegativaQuantitiesFromCart() {
		
		Cart cart = new Cart();
		
		cart.verifyQuantityAndAddItems(1, 5);
		cart.removeItemsAndAdjustInventory(1, -5);
		
		System.out.println(cart.getPrice() +" "+ cart.getProductQuantityInCartBySku(1));
		System.out.println(cart.StoreInventory.getProductQuantityBySKU(1));
	}
	
	@Test
	public void getProductsFromCart() {
		Cart cart = new Cart();
		cart.addItems(1, 4);
		
		List<Products> list = cart.getProducts();
		
		Assert.assertTrue(list.get(0) == cart.getProductData(1));
	}
}
