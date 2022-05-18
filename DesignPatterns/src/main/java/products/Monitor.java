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
								+" Resolution:" + this.getScreenResolution()
								+" Price:"+ Double.toString(this.getPrice())
								+" Weight:"+Double.toString(this.getWeight()) +"KGs"
				;}
}
