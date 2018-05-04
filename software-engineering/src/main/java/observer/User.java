package observer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements IUser{
	public String name;
	public Set<String> hobbies;
	
	public User(String name, Set<String> hobbies) {
		this.name = name;
		this.hobbies = hobbies;
	}
	
	public void changeName(String newName) {
		this.name = newName;
	}
	
	public void addHobby(String newHobby) {
		this.hobbies.add(newHobby);
	}
	
	@Override
	public String toString() {
		return this.name + "\n" + hobbies.toString();
	}
	
	public Set<String> getHobbies() {
		return new HashSet<String>(this.hobbies);
	}
}
