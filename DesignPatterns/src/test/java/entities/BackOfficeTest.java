package entities;

import org.junit.Test;

public class BackOfficeTest {

	
	@Test
	public void backOfficeNotificationTest() {
		
		//scene
		BackOffice back = new BackOffice();
		OrderList.getInstance().subscribe(back);
		Order order = new Order();
		
		//action
		order.toPaid();
		back.ping(1);
		
		//verify
		
	}
	
}
