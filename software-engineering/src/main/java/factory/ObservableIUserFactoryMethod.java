package factory;

import java.util.HashSet;

import observer.IUser;
import observer.ObservableIUser;

public class ObservableIUserFactoryMethod extends IUserFactoryMethod {
	
	@Override
	public IUser getIUserInstance() {
		return new ObservableIUser("", new HashSet<String>());
	}
}
