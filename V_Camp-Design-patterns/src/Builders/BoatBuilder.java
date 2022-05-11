package Builders;

import Interfaces.IProductBuilder;
import Products.Boat;
import abstracts.Products;

public class BoatBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private int EnginePower;
	private int SizeInFeet;
	
	private Boat boat;

	@Override
	public BoatBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public BoatBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public BoatBuilder setSKU() {
		this.SKU = Products.ID;
		Products.ID++;
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

	@Override
	public Boat build() {
		boat = new Boat(SKU, Price, Weight, ReservedQuantity, StockQuantity, EnginePower, SizeInFeet);
		return boat;
	}

	@Override
	public Products getProduct() {
		return boat;
	}
	

}
