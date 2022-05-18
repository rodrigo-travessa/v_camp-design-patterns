package interfaces;

import abstracts.Products;

public interface IProductBuilder {
	
	IProductBuilder setSKU(int sku);	
	IProductBuilder setPrice(double price);
	IProductBuilder setWeight(double weight);
	
	
	Products build();
	Products getProduct();
}
