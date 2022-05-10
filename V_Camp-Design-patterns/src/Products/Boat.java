package Products;

import abstracts.Products;

public class Boat extends Products {
	
	private int EnginePower;
	private int SizeInFeet;
	
	public Boat(int sku, double price, double weight, int enginePower,int sizeInFeet) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		EnginePower = enginePower;
		SizeInFeet = sizeInFeet;
	}

	public int getEnginePower() {
		return EnginePower;
	}

	public int getSizeInFeet() {
		return SizeInFeet;
	}

}
