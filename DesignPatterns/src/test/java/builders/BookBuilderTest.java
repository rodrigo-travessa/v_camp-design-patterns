package builders;

import org.junit.Assert;
import org.junit.Test;

import products.Book;

public class BookBuilderTest {

	@Test
	public void builderWorkingProperly() {
		
		BookBuilder bookBuilder = new BookBuilder();
		bookBuilder.setSKU(1).setPrice(10000).setWeight(1000);
		bookBuilder.setStockQuantity(10).setReservedQuantity(0);
		bookBuilder.setAuthor("Teste").setNumberOfPages(600);
		Book book = bookBuilder.build();
		
		Assert.assertTrue(book.getSKU() == 1);
		Assert.assertTrue(book.getPrice() == 10000);
		Assert.assertTrue(book.getWeight() == 1000);
		Assert.assertTrue(book.getStockQuantity() == 10);
		Assert.assertTrue(book.getReservedQuantity() == 0);
		Assert.assertTrue(book.getAuthor() == "Teste");
		Assert.assertTrue(book.getNumberOfPages() == 600);
	}
}
