package Shipping;

public class AirShipping implements IShippingInterface {

	@Override
	public ShippingVehicle DefineTransport() {
		return new Plane();

	}

}
