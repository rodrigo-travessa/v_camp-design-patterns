package Products;

import abstracts.Products;

public class Monitor extends Products {
	
	private int SizeInInches;
	private String ScreenResolution;

	


	public Monitor(int sku, double price, double weight, int sizeInInches, String screenResolution) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		SizeInInches = sizeInInches;
		ScreenResolution = screenResolution;
		
	}
	public int getSizeInInches() {
		return SizeInInches;
	}
	
	
	public String getScreenResolution() {
		return ScreenResolution;
	}
}
