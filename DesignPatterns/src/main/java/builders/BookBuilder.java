package builders;

import abstracts.Products;
import interfaces.IProductBuilder;
import products.Book;

public class BookBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private String Author;
	private int NumberOfPages;
	private Book book;
		
	public BookBuilder setSKU(int sku) {
		this.SKU = sku;
		return this;
	}

	public BookBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	public BookBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	
	public BookBuilder setStockQuantity(int quantity) {
		this.StockQuantity = quantity;
		return this;
		
	}
	
	public BookBuilder setReservedQuantity (int quantity) {
		this.ReservedQuantity = quantity;
		return this;
	}
	
	public BookBuilder setAuthor (String author) {
		this.Author = author;
		return this;
	}
	
	public BookBuilder setNumberOfPages(int pages) {
		this.NumberOfPages = pages;
		return this;
	}

	public Book build() {
		book = new Book();
		book.SKU = this.SKU;
		book.Price = this.Price;
		book.Weight = this.Weight;
		book.StockQuantity = this.StockQuantity;
		book.ReservedQuantity = this.ReservedQuantity;
		book.NumberOfPages = this.NumberOfPages;
		book.Author = this.Author;
		return book;
	}

	public Products getProduct() {
		return book;
	}

}
