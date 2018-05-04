package factory;

import java.util.HashSet;

import observer.IUser;
import observer.User;

public class IUserFactoryMethod implements IUserFactory {

	@Override
	public IUser getIUserInstance() {
		// TODO Auto-generated method stub
		return new User("", new HashSet<String>());
	}
	
	
}
