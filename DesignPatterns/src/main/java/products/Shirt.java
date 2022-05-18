package products;

import abstracts.Products;

public class Shirt extends Products {

	public String Color;
	public String Brand;


	public Shirt() {}

	public String getColor() {
		return Color;
	}

	public String getBrand() {
		return Brand;
	}

	public String toString() {

		return	"Shirt:"+" Brand:" + this.getBrand()
						+" Color:" + this.getColor() 
						+" Price:"+ Double.toString(this.getPrice())
						+" Weight:"+Double.toString(this.getWeight()) +"KGs"
						;}

}
