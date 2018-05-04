package observer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An example of a custom Observer pattern design without using the
 * Java Observer/Observable library.
 * 
 * PROS: 
 * - Can extend from a class other than Observable
 * CONS: 
 * - Constrained to observers that must implement 
 * a specific IUserObserver interface
 * - More code to implement code for custom Observer/Observable
 * 
 * We can also generalize observers to be Consumer<T> and implement
 * the Consumers accept() to do something like counting or logging.
 * We can construct them as Consumer<IUser> and add them to the 
 * observable.
 * 
 * @author kevin
 *
 */

public class ObservableIUser extends User {
	
	Set<IUserObserver> observers = new HashSet<IUserObserver>();
	
	public ObservableIUser(String name, Set<String> hobbies) {
		super(name, hobbies);
		// TODO Auto-generated constructor stub
	}
	
	public void addIUserObserver(IUserObserver observer) {
		this.observers.add(observer);
	}
	
	@Override
	public void changeName(String newName) {
		super.changeName(newName);
		this.notifyObservers();
	}
	
	@Override
	public void addHobby(String newHobby) {
		super.addHobby(newHobby);
		this.notifyObservers();
	}
	
	public void notifyObservers() {
		for (IUserObserver observer: this.observers) {
			observer.onUpdate(this);
		}
	}
	

}
