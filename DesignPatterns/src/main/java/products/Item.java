package products;

import abstracts.Products;

public class Item {
	
	public int SKU;
	public int quantityInCart;
	
	public Item(int sku, int quantity) {
		this.SKU = sku;
		this.quantityInCart = quantity;
	}
	
}
