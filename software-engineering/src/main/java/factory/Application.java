package factory;

import observer.IUser;

/**
 * Abstract Factory Design Pattern.
 * 
 * @author kevin
 *
 */

public class Application {
	
	IUserFactory factory;
	
	public Application(IUserFactory userFactory) {
		this.factory = userFactory;
	}
	
	public void run() {
		IUser user1 = this.factory.getIUserInstance();
		IUser user2 = this.factory.getIUserInstance();
		IUser user3 = this.factory.getIUserInstance();
		
		// Do something with these instances...
		// I.e. if server receives a signup request,
		// then instantiate an IUser with the factory
		// and change its name and hobbies
	}
	
}
