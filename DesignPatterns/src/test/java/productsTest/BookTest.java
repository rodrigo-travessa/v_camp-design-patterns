package productsTest;

import org.junit.Assert;
import org.junit.Test;

import products.Book;
import products.Monitor;

public class BookTest {
	
	@Test
	public void cloneTest() {
		Book book = new Book();
		book.Author = "Teste";
		book.NumberOfPages = 600;
		book.Price = 10.0;
		book.ReservedQuantity = 0;
		book.StockQuantity = 10;
		book.SKU = 1;
		book.Weight = 1.0;
		
		Book clonedBook = book.clone();
		
		Assert.assertTrue(book != clonedBook);
		Assert.assertTrue(book.getAuthor() == clonedBook.getAuthor());
		Assert.assertTrue(book.getNumberOfPages() == clonedBook.getNumberOfPages());
		Assert.assertTrue(book.getPrice() == clonedBook.getPrice());
		Assert.assertTrue(book.getReservedQuantity() == clonedBook.getReservedQuantity());
		Assert.assertTrue(book.getStockQuantity() == clonedBook.getStockQuantity());
		Assert.assertTrue(book.getSKU() == clonedBook.getSKU());
		Assert.assertTrue(book.getWeight() == clonedBook.getWeight());
	}
	
	@Test
	public void toStringTest() {
		
		Book book = new Book();
		book.Author = "Teste";
		book.NumberOfPages = 600;
		book.Price = 10.0;
		book.ReservedQuantity = 0;
		book.StockQuantity = 10;
		book.SKU = 1;
		book.Weight = 1.0;
		
		System.out.println(book.toString());
		Assert.assertTrue(book.toString().equals("Book:SKU: 1 Author:Teste, Pages:600, Price:10.0, Weight:1.0KGs;"));
	}

}
