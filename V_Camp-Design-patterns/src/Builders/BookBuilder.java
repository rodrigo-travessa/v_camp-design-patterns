package Builders;

import Interfaces.IProductBuilder;
import Products.Book;
import abstracts.Products;

public class BookBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private String Author;
	private int NumberOfPages;

	@Override
	public BookBuilder withPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public BookBuilder withWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public BookBuilder withSKU() {
		this.SKU = Products.ID;
		Products.ID ++;
		return this;
	}
	
	public BookBuilder withAuthor(String author) {
		
		this.Author = author;
		
		return this;
	}
	
	public BookBuilder withNumberOfPages(int numberOfPages) {
		
		this.NumberOfPages = numberOfPages;
		
		return this;
	}
	
	
	
	

	@Override
	public Book build() {
		return new Book(SKU, Price, Weight, Author, NumberOfPages);
	}

	@Override
	public BookBuilder getProduct() {
		return this;
	}

}
