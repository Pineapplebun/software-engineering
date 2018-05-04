package builder;

import java.util.Map;

import builder.UserData.Builder;

public interface IUserData {
	public static class Builder {};
	
	public String getLocation();
	public Map<String, Integer> getProductsBought();
	public int getNumberWebsiteVisits();
	public int getTotalTimeBrowsing();
	
}
