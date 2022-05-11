package abstracts;

public abstract class Products {
	
	public static int ID = 1;
	
	public int SKU;
	public int StockQuantity;
	public int ReservedQuantity;
	public double Price;
	public double Weight;
	
	public Products() {}
	
	public Products(int sku, double price, double weight, int stockQuantity, int reservedQuantity ) {
		this.Price = price;
		this.Weight = weight;
		this.SKU = sku;
		this.StockQuantity = stockQuantity;
		this.ReservedQuantity = reservedQuantity;
	}
	
	public static int getID() {
		return ID;
	}

	public int getStockQuantity() {
		return StockQuantity;
	}

	public int getReservedQuantity() {
		return ReservedQuantity;
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
