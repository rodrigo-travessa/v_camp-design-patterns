package Builders;

import Interfaces.IProductBuilder;
import Products.Camisa;
import abstracts.Products;

public class CamisaBuilder implements IProductBuilder {

	private int SKU;
	private double Price;
	private double Weight;
	private String Brand;
	private String Color;
	
	
	@Override
	public CamisaBuilder withPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public CamisaBuilder withWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public CamisaBuilder withSKU() {
		this.SKU = Products.ID;
		Products.ID ++;
		return this;
	}
		
	public CamisaBuilder withBrand(String brand) {
		this.Brand = brand;
		return this;
	}	
	
	public CamisaBuilder withColor(String color) {
		this.Color = color;
		return this;
	}	

	@Override
	public Camisa build() {	 
		
		return new Camisa(SKU, Price, Weight,Color, Brand);
	}

	@Override
	public Camisa getProduct() {
		return null;
	}

}
