package products;

import abstracts.Products;

public class Boat extends Products {

	public int EnginePower;
	public int SizeInFeet;

	public Boat() {}

	public int getEnginePower() {
		return EnginePower;
	}

	public int getSizeInFeet() {
		return SizeInFeet;
	}
	public String toString() {

		return	"Boat:" +"SKU: " +this.getSKU()
						+" EnginePower:" + this.getEnginePower() +"HP"
						+", SizeInFeet:" + this.getSizeInFeet()
						+", Price:"+ Double.toString(this.getPrice())
						+", Weight:"+Double.toString(this.getWeight()) +"KGs;"
				;}
	
	
	public Boat clone() {
		Boat boat = new Boat();
		boat.SKU = this.getSKU();
		boat.Price = this.getPrice();
		boat.Weight = this.getWeight();
		boat.StockQuantity = this.getStockQuantity();
		boat.ReservedQuantity = this.getReservedQuantity();
		boat.EnginePower = this.getEnginePower();
		boat.SizeInFeet = this.getSizeInFeet();
		return boat;
	}

}
