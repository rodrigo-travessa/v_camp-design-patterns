package Builders;

import Interfaces.IProductBuilder;
import Products.Shirt;
import abstracts.Products;

public class ShirtBuilder implements IProductBuilder {

	private int SKU;
	private double Price;
	private double Weight;
	private String Brand;
	private String Color;
	
	
	@Override
	public ShirtBuilder withPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public ShirtBuilder withWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public ShirtBuilder withSKU() {
		this.SKU = Products.ID;
		Products.ID ++;
		return this;
	}
		
	public ShirtBuilder withBrand(String brand) {
		this.Brand = brand;
		return this;
	}	
	
	public ShirtBuilder withColor(String color) {
		this.Color = color;
		return this;
	}	

	@Override
	public Shirt build() {	 
		
		return new Shirt(SKU, Price, Weight,Color, Brand);
	}

	@Override
	public ShirtBuilder getProduct() {
		return this;
	}

}
