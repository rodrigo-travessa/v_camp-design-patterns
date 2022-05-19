package entities;

import interfaces.IShipping;
import shippingMethods.Aero;
import shippingMethods.Road;

public class ShippingFactory {
	
	public IShipping getShipping(double weight) {
		if (weight <= 10) { 
			return new Aero();
		} else {
			return new Road();
		}
	}

}
