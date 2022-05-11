package Interfaces;

import abstracts.Products;

public interface IProductBuilder {
	
	IProductBuilder setPrice(double price);
	
	IProductBuilder setWeight(double weight);	

	IProductBuilder setSKU();	

	
	Products build();
	
	Products getProduct();
}
