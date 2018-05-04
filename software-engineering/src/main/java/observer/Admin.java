package observer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Admin implements IAdmin {
	
	private int numUpdates;
	private Set<IUser> updateSet; 
	
	public Admin() {
		this.numUpdates = 0;
		this.updateSet = new LinkedHashSet<IUser>();
	}
	
	public void onUpdate(ObservableIUser user) {
		System.out.println(user.toString());
		numUpdates++;
		updateSet.add(user);
	}
	
	public int getNumUpdates() {
		return this.numUpdates;
	}
	
	public Set<IUser> getUpdateSet() {
		return new LinkedHashSet<IUser>(this.updateSet);
	}

}
