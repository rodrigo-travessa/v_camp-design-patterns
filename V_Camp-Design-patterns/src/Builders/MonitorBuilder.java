package Builders;

import Interfaces.IProductBuilder;
import Products.Monitor;
import abstracts.Products;

public class MonitorBuilder implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int SizeInInches;
	private String ScreenResolution;

	@Override
	public MonitorBuilder withPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public MonitorBuilder withWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public MonitorBuilder withSKU() {
		this.SKU = Products.ID;
		Products.ID ++;
		return this;
	}
	
	public MonitorBuilder withSizeInInches(int sizeInInches) {
		this.SizeInInches = sizeInInches;
		return this;
	}
	
	public MonitorBuilder withScreenResolution(String screenResolution) {
		this.ScreenResolution = screenResolution;
		return this;
	}

	@Override
	public Monitor build() {
		return new Monitor(SKU, Price, Weight, SizeInInches, ScreenResolution);
	}

	@Override
	public MonitorBuilder getProduct() {
		return this;
	}

}
