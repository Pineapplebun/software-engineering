package factory;

import observer.IUser;

/**
 * Problem: 
 * 
 * We require instances of certain classes, but the classes which need
 * them should not instantiate them, and thus be dependent on them, since
 * we want single responsibility and less dependencies (more DI).
 * 
 * Factory Method Design Pattern.
 * 
 * IUserFactory is an interface, whilst IUserFactoryMethod() is a concrete class.
 * Here we don't have an abstract factory since we do not pass the factory via 
 * composition to an application that requires IUser instances.
 * 
 * We assume the main method is the application to run.
 * 
 * ALTERNATE
 * ====================================================
 * 
 * Abstract Factory Design Pattern (Using Factory Method)
 * 
 * 
 * @author kevin
 *
 */

public class Main {

	public static void main(String[] args) {
		
		// Factory Method Design Pattern
		IUserFactory factory1 = new IUserFactoryMethod();
		// Retrieve an instance from this factory 
		IUser user1 = factory1.getIUserInstance();
		
		// Retrieve an Observable instance from a subclass of IUserFactoryMethod()
		IUserFactory factory2 = new ObservableIUserFactoryMethod();
		IUser user2 = factory2.getIUserInstance();
		
		// Do something with the IUser in this main program...
		
		// ALTERNATE: Abstract Factory Design Pattern
		// The application has a factory and handles what to do
		new Application(factory1).run();
		new Application(factory2).run();
			
	}

}
