package Products;

import abstracts.Products;

public class Book extends Products {
	
	private String Author;
	private int NumberOfPages;

	
	public Book(int sku, double price, double weight, String author,int numberOfPages) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		Author = author;
		NumberOfPages = numberOfPages;
	}


	public String getAuthor() {
		return Author;
	}


	public int getNumberOfPages() {
		return NumberOfPages;
	}
}
