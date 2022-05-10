package abstracts;

public abstract class Products {
	
	public static int ID = 1;
	
	
	protected int SKU;
	protected double Price;
	protected double Weight;
	
	
	public Products() {}
	
	public Products(double price, double weight, int sku) {
		this.Price = price;
		this.Weight = weight;
		this.SKU = sku;
	}
	
	public int getSKU() {
		return SKU;
	}
	
	public double getPrice() {
		return Price;
	}
	
	public double getWeight() {
		return Weight;
	}
	
	
	

}
