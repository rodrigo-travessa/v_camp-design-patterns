package abstracts;

public abstract class Products {

	public int SKU;
	public double Price;
	public double Weight;
	public int StockQuantity; 
	public int ReservedQuantity;
	
	public Products() {}
	
	public Products(int sku, double price, double weight, int stockQuantity, int reservedQuantity) {
		
		this.SKU = sku;
		this.Price = price;
		this.Weight = weight;
		this.StockQuantity = stockQuantity;
		this.ReservedQuantity = reservedQuantity;
	}
	
	/*
	 * Rompendo principio de responsabilidade unica, o carrinho não deveria ter dados sobre estoque ou carrinho
	 */
	
	public int getSKU() {
		return SKU;
	}
	
	public double getPrice() {
		return Price;
	}
	
	public double getWeight() {
		return Weight;
	}

	public int getStockQuantity() {
		return StockQuantity;
	}

	public int getReservedQuantity() {
		return ReservedQuantity;
	}
	
	public Products clone() {
		return null;
		
	}

}
