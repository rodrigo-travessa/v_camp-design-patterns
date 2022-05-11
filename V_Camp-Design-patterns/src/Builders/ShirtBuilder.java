package Builders;

import Interfaces.IProductBuilder;
import Products.Shirt;
import abstracts.Products;


public class ShirtBuilder implements IProductBuilder {

	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;
	private String Brand;
	private String Color;
	
	private Shirt shirt;
	
	public ShirtBuilder setBrand(String brand) {
		this.Brand = brand;
		return this;
	}	
	
	public ShirtBuilder setColor(String color) {
		this.Color = color;
		return this;
	}	

	@Override
	public Shirt build() {	 
		
		shirt = new Shirt(SKU, Price, Weight,Color, Brand, StockQuantity, ReservedQuantity);
		return shirt; 
	}

	@Override
	public Shirt getProduct() {
		return shirt;
	}

	@Override
	public ShirtBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public ShirtBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public ShirtBuilder setSKU() {
		this.SKU = Products.ID;
		Products.ID++;
		return this;
	}
	
	public ShirtBuilder setStockQuantity(int quantity) {
		this.StockQuantity = quantity;
		return this;
		
	}
	
	public ShirtBuilder setReservedQuantity (int quantity) {
		this.ReservedQuantity = quantity;
		return this;
	}

}
