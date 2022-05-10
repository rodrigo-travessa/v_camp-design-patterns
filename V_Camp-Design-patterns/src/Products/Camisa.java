package Products;

import abstracts.Products;

public class Camisa extends Products {
	
	
	
	private String Color;
	private String Brand;
	
	
	public Camisa(int sku, double price, double weight, String color,String brand) {
		super();
		SKU = sku;
		Price = price;
		Weight = weight;
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
		
			return		this.getColor() 
						+" "
						+ this.getBrand()
						+" "
						+ Double.toString(this.getPrice())
						+" "
						+ Double.toString(this.getWeight())
						+" "
						+ Integer.toString(this.getSKU());
				
		
	}
	
}
