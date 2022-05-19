package entities;

import interfaces.IObservers;

public class BackOffice implements IObservers {

	@Override
	public void ping(int ID) {
		System.out.println("Get Info About Order with order ID: "+ ID + ";");
	}

}
