package Shipping;

public class RoadShipping implements IShippingInterface {

	@Override
	public ShippingVehicle DefineTransport() {
		return new Truck();

	}

}
