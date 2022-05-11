package Products;

import abstracts.Products;

public class Shirt extends Products {

	private String Color;
	private String Brand;


	public Shirt(int sku, double price, double weight, String color,String brand, int stockQuantity, int reservedQuantity) {
		super(sku, price, weight, stockQuantity, reservedQuantity);
		Color = color;
		Brand = brand;
	}

	public String getColor() {
		return Color;
	}

	public String getBrand() {
		return Brand;
	}

	public String toString() {

		return		"Brand:" + this.getBrand()
		+" "
		+"Color:" + this.getColor() 
		+" "
		+"Price:"+ Double.toString(this.getPrice())
		+" "
		+"Weight:"+Double.toString(this.getWeight()) +"KGs \n"
		;}

}
