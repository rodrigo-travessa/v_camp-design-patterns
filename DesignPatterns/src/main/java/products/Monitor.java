package products;

import abstracts.Products;

public class Monitor extends Products {

	public int SizeInInches;
	public String ScreenResolution;




	public Monitor() {}
	
	public int getSizeInInches() {
		return SizeInInches;
	}


	public String getScreenResolution() {
		return ScreenResolution;
	}
	public String toString() {

		return		"Monitor:"  +" Size:" + this.getSizeInInches() +"\""
								+", Resolution:" + this.getScreenResolution()
								+", Price:"+ Double.toString(this.getPrice())
								+", Weight:"+Double.toString(this.getWeight()) +"KGs;"
				;}
	
	public Monitor clone() {
		Monitor monitor = new Monitor();
		monitor.SKU = this.getSKU();
		monitor.Price = this.getPrice();
		monitor.Weight = this.getWeight();
		monitor.StockQuantity = this.getStockQuantity();
		monitor.ReservedQuantity = this.getReservedQuantity();
		monitor.SizeInInches = this.getSizeInInches();
		monitor.ScreenResolution = this.getScreenResolution();
		return monitor;
	}
	
}
