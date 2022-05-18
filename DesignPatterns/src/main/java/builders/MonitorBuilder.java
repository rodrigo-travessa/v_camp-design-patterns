package builders;

import abstracts.Products;
import interfaces.IProductBuilder;
import products.Monitor;

public class MonitorBuilder  implements IProductBuilder {
	
	private int SKU;
	private double Price;
	private double Weight;
	private int StockQuantity;
	private int ReservedQuantity;

	private int SizeInInches;
	private String ScreenResolution;
	private Monitor monitor;
	
	
	public MonitorBuilder setSKU(int sku) {
		this.SKU = sku;
		return this;
	}
	
	public MonitorBuilder setPrice(double price) {
		this.Price = price;
		return this;
	}

	public MonitorBuilder setWeight(double weight) {
		this.Weight = weight;
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

	public MonitorBuilder setScreenResolution(String string) {
		this.ScreenResolution = string;
		return this;
	}
	
	public MonitorBuilder setSizeInInches(int i) {
		this.SizeInInches = i;
		return this;
	}
	
	public Monitor build() {
		monitor = new Monitor();
		monitor.SKU = this.SKU;
		monitor.Price = this.Price;
		monitor.Weight = this.Weight;
		monitor.StockQuantity = this.StockQuantity;
		monitor.ReservedQuantity = this.ReservedQuantity;
		monitor.SizeInInches = this.SizeInInches;
		monitor.ScreenResolution = this.ScreenResolution;
		return monitor;
	}

	public Products getProduct() {
		return monitor;
	}


}
