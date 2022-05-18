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

		return	"Boat:" +" EnginePower:" + this.getEnginePower() +"HP"
						+" SizeInFeet:" + this.getSizeInFeet()
						+" Price:"+ Double.toString(this.getPrice())
						+" Weight:"+Double.toString(this.getWeight()) +"KGs"
				;}

}
