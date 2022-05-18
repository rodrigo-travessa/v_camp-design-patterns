package builders;

import abstracts.Products;
import interfaces.IProductBuilder;
import products.Boat;

public class BoatBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private int EnginePower;
	private int SizeInFeet;
	
	private Boat boat;

	public BoatBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	public BoatBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	public BoatBuilder setSKU(int sku) {
		this.SKU = sku;
		return this;
	}
	
	public BoatBuilder setStockQuantity(int quantity) {
		this.StockQuantity = quantity;
		return this;
		
	}
	
	public BoatBuilder setReservedQuantity (int quantity) {
		this.ReservedQuantity = quantity;
		return this;
	}
	
	public BoatBuilder setEnginePower (int enginePower) {
		this.EnginePower = enginePower;
		return this;
	}
	
	public BoatBuilder setSizeinFeet (int size) {
		this.SizeInFeet = size;
		return this;
	}

	public Boat build() {
		boat = new Boat();
		boat.SKU = this.SKU;
		boat.Price = this.Price;
		boat.Weight = this.Weight;
		boat.StockQuantity = this.StockQuantity;
		boat.ReservedQuantity = this.ReservedQuantity;
		boat.EnginePower = this.EnginePower;
		boat.SizeInFeet = this.SizeInFeet;
		return boat;
	}

	public Products getProduct() {
		return boat;
	}
	

}
