package Interfaces;

import abstracts.Products;

public interface IProductBuilder {
	
	IProductBuilder withPrice(double price);
	
	IProductBuilder withWeight(double weight);	

	IProductBuilder withSKU();	

	
	Products build();
	
	IProductBuilder getProduct();
}
