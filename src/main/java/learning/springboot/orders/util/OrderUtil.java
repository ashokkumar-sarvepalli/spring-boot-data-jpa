package learning.springboot.orders.util;

import java.util.UUID;

public class OrderUtil {

	public static String generateUUIDAsString() {
		return UUID.randomUUID().toString();
	}
	

}
