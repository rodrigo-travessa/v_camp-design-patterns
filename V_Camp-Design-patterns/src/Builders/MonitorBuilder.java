package Builders;

import Interfaces.IProductBuilder;
import Products.Monitor;
import abstracts.Products;

public class MonitorBuilder  implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private int SizeInInches;
	private String ScreenResolution;
	private Monitor monitor;
	
	@Override
	public MonitorBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	@Override
	public MonitorBuilder setWeight(double weight) {
		this.Weight = weight;
		return this;
	}

	@Override
	public MonitorBuilder setSKU() {
		this.SKU = Products.ID;
		Products.ID++;
		return this;
	}
	
	public MonitorBuilder setStockQuantity(int quantity) {
		this.StockQuantity = quantity;
		return this;
		
	}
	
	public MonitorBuilder setReservedQuantity (int quantity) {
		this.ReservedQuantity = quantity;
		return this;
	}

	@Override
	public Monitor build() {
		monitor = new Monitor(SKU, Price, Weight, StockQuantity, ReservedQuantity, SizeInInches, ScreenResolution);
		return monitor;
	}

	@Override
	public Products getProduct() {
		return monitor;
	}

	public MonitorBuilder setScreenResolution(String string) {
		this.ScreenResolution = string;
		return this;
	}

	public MonitorBuilder setSizeInInches(int i) {
		this.SizeInInches = i;
		return this;
	}

}
