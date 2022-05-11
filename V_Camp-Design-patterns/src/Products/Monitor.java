package Products;

import Interfaces.IProduct;
import abstracts.Products;

public class Monitor extends Products implements IProduct {

	private int SizeInInches;
	private String ScreenResolution;




	public Monitor(int sku, double price, double weight, int stockQuantity, int reservedQuantity, int sizeInInches, String screenResolution) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		SizeInInches = sizeInInches;
		ScreenResolution = screenResolution;
		StockQuantity = stockQuantity;
		ReservedQuantity = reservedQuantity;
	}
	
	public int getSizeInInches() {
		return SizeInInches;
	}


	public String getScreenResolution() {
		return ScreenResolution;
	}
	public String toString() {

		return		"Size:" + this.getSizeInInches() +"\""
				+" "
				+"Resolution:" + this.getScreenResolution()
				+" "
				+"Price:"+ Double.toString(this.getPrice())
				+" "
				+"Weight:"+Double.toString(this.getWeight()) +"KGs \n"
				;}
}
