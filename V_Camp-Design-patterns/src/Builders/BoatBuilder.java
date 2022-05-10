package Builders;

import Interfaces.IProductBuilder;
import Products.Boat;
import abstracts.Products;

public class BoatBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int EnginePower;
	private int SizeInFeet;

	@Override
	public BoatBuilder withPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public BoatBuilder withWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public BoatBuilder withSKU() {
		this.SKU = Products.ID;
		Products.ID ++;
		return this;
	}
	
	public BoatBuilder withEnginePower(int enginePower) {
		this.EnginePower = enginePower;
		return this;
	}

	public BoatBuilder withSizeInFeet(int sizeInFeet) {
		this.SizeInFeet = sizeInFeet;
		return this;
	}

	@Override
	public Boat build() {
		
		return new Boat(SKU, Price, Weight, EnginePower, SizeInFeet);
	}

	@Override
	public BoatBuilder getProduct() {
		return this;
	}

}
