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

		return	"Shirt:"+"SKU: " +this.getSKU()
						+" Brand:" + this.getBrand()
						+", Color:" + this.getColor() 
						+", Price:"+ Double.toString(this.getPrice())
						+", Weight:"+Double.toString(this.getWeight()) +"KGs;"
						;}

	@Override
	public Shirt clone() {
		
		Shirt shirt = new Shirt();
		shirt.SKU = this.getSKU();
		shirt.Price = this.getPrice();
		shirt.Weight = this.getWeight();
		shirt.StockQuantity = this.getStockQuantity();
		shirt.ReservedQuantity = this.getReservedQuantity();
		shirt.Brand = this.getBrand();
		shirt.Color = this.getColor();
		return shirt;
	}
}
