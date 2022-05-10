package client;

import Builders.CamisaBuilder;
import Entities.ProductInventory;
import Interfaces.IProductBuilder;
import Products.Camisa;
import abstracts.Products;

public class Client {

	public static void main(String[] args) {

		
		var inventario = ProductInventory.getInstance();
		
		
		CamisaBuilder builder = new CamisaBuilder();
		
		Camisa camisa = builder.withSKU()
									.withPrice(10.0d)
									.withWeight(1.0d)
									.withBrand("Billabong")
									.withColor("Red")
								.build();	
		
		
		
		System.out.println(camisa.toString());
		
		
		
		
		
		
		
		
		
	}
	
}
