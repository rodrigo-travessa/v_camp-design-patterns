package Products;

import abstracts.Products;

public class Boat extends Products {

	private int EnginePower;
	private int SizeInFeet;

	public Boat(int sku, double price, double weight, int stockQuantity,int reservedQuantity, int enginePower, int sizeInFeet) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
		StockQuantity = stockQuantity;
		ReservedQuantity = reservedQuantity;
		EnginePower = enginePower;
		SizeInFeet = sizeInFeet;
		
	}

	public int getEnginePower() {
		return EnginePower;
	}

	public int getSizeInFeet() {
		return SizeInFeet;
	}
	public String toString() {

		return	
				"EnginePower:" + this.getEnginePower() +"HP"
				+" "
				+"SizeInFeet:" + this.getSizeInFeet()
				+" "
				+"Price:"+ Double.toString(this.getPrice())
				+" "
				+"Weight:"+Double.toString(this.getWeight()) +"KGs \n"
				;}

}
