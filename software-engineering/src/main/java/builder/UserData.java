package builder;

import java.util.HashMap;
import java.util.Map;

public class UserData implements IUserData {
	
	private String location;
	private Map<String, Integer> productsBought;
	private int numberWebsiteVisits;
	private int totalTimeBrowsing;
	
	public static class Builder {
		
		private String location;
		private Map<String, Integer> productsBought;
		private int numberWebsiteVisits;
		private int totalTimeBrowsing;
		
		public Builder location(String location) {
			this.location = location;
			return this;
		}
		
		public Builder productsBought(Map<String, Integer> products) {
			this.productsBought = products;
			return this;
		}
		
		public Builder numberWebsitesVisits(int numberWebsiteVisits) {
			this.numberWebsiteVisits = numberWebsiteVisits;
			return this;
		}
		
		public Builder totalTimeBrowsing(int totalTimeBrowsing) {
			this.totalTimeBrowsing = totalTimeBrowsing;
			return this;
		}
		
		// UserData can only be instantiated if all properties have
		// been set. 
		public IUserData build() {		
			// validate properties here...
			return new UserData(this);
		}
	}
	
	// The only way to retrieve a UserData is through Builder
	private UserData(Builder builder) {
		this.location = builder.location;
		this.productsBought = builder.productsBought;
		this.numberWebsiteVisits = builder.numberWebsiteVisits;
		this.totalTimeBrowsing = builder.totalTimeBrowsing;
	}
	
	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	@Override
	public Map<String, Integer> getProductsBought() {
		// TODO Auto-generated method stub
		return new HashMap<String, Integer>(this.productsBought);
	}

	@Override
	public int getNumberWebsiteVisits() {
		// TODO Auto-generated method stub
		return this.numberWebsiteVisits;
	}

	@Override
	public int getTotalTimeBrowsing() {
		// TODO Auto-generated method stub
		return this.totalTimeBrowsing;
	}

}
