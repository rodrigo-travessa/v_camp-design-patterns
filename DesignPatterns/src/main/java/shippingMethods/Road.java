package shippingMethods;

import interfaces.IShipping;

public class Road implements IShipping {

	@Override
	public String description() {
		return "Road";
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
