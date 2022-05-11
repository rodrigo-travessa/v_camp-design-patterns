package Builders;

import Interfaces.IProductBuilder;
import Products.Book;
import abstracts.Products;

public class BookBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private String Author;
	private int NumberOfPages;
	private Book book;
		
	@Override
	public BookBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public BookBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public BookBuilder setSKU() {
		this.SKU = Products.ID;
		Products.ID++;
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

	@Override
	public Book build() {
		book = new Book(SKU, Price, Weight, StockQuantity, ReservedQuantity, Author, NumberOfPages);
		return book;
	}

	@Override
	public Products getProduct() {
		// TODO Auto-generated method stub
		return book;
	}

	

}
