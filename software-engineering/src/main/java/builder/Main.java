package builder;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		IUserData userData1 = new
				UserData.Builder().location("Toronto")
				.productsBought(new HashMap<String, Integer>())
				.numberWebsitesVisits(10)
				.totalTimeBrowsing(10)
				.build();
		
		System.out.println(userData1.getLocation());
		System.out.println(userData1.getProductsBought());
		System.out.println(userData1.getNumberWebsiteVisits());
		System.out.println(userData1.getTotalTimeBrowsing());
		
		try {
			IUserData userData2 = new
					UserData.Builder()
					.location("Toronto")
					.productsBought(new HashMap<String, Integer>())
					.numberWebsitesVisits(10)
					.build();
			
			System.out.println(userData2.getLocation());
		} catch(Exception e) {
			System.out.println("Unset parameter");
		}
	}

}
