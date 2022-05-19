package shippingMethods;

import interfaces.IShipping;

public class Aero implements IShipping {

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Aero";
	}

	@Override
	public double shipingPrice(double price, int itemQuantity) {
		if (price <= 799) {
			return 7.99 + itemQuantity;
		} else {
			return (price * 0.1) + itemQuantity;
		}
	}

}
