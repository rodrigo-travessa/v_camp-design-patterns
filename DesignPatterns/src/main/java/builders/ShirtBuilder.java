package builders;

import interfaces.IProductBuilder;
import products.Shirt;


public class ShirtBuilder implements IProductBuilder {

	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;
	private String Brand;
	private String Color;
	
	private Shirt shirt;
	
	public ShirtBuilder setSKU(int sku) {
		this.SKU = sku;
		return this;
	}

	public ShirtBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	public ShirtBuilder setWeight(double weight) {
		this.Weight = weight;
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
	
	public ShirtBuilder setBrand(String brand) {
		this.Brand = brand;
		return this;
	}	
	
	public ShirtBuilder setColor(String color) {
		this.Color = color;
		return this;
	}	

	public Shirt build() {
		shirt = new Shirt();
		shirt.SKU = this.SKU;
		shirt.Price = this.Price;
		shirt.Weight = this.Weight;
		shirt.StockQuantity = this.StockQuantity;
		shirt.ReservedQuantity = this.ReservedQuantity;
		shirt.Brand = this.Brand;
		shirt.Color = this.Color;
		return shirt;
	}
	
	public Shirt getProduct() {
		return shirt;
	}
}
