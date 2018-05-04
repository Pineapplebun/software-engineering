package test.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.junit.Test;

import observer.Admin;
import observer.IAdmin;
import observer.IUser;
import observer.IUserObserver;
import observer.ObservableIUser;

public class ObserverTest {
	
	public static <T, R> boolean assertByBiPredicate(
			BiPredicate<T, R> predicate, T objectA, R objectB) {
		return predicate.test(objectA, objectB);
	}
	
	@Test
	public void checkNumUpdatesTest() throws Exception{
		// create testing environment
		ObservableIUser user1 = new ObservableIUser("kevin", new HashSet<String>());
		IAdmin admin1 = new Admin();
		user1.addIUserObserver(admin1);
		
		user1.addHobby("Tennis");
		assertEquals(admin1.getNumUpdates(), 1);
		
	}
	
	@Test
	public void checkRepeatedHobbyTest() throws Exception{
		// create testing environment
		ObservableIUser user1 = new ObservableIUser("kevin", new HashSet<String>());
		IAdmin admin1 = new Admin();
		user1.addIUserObserver(admin1);
		
		user1.addHobby("Tennis");
		user1.addHobby("Tennis");
		assertEquals(admin1.getUpdateSet().size(), 1);
		assertEquals(user1.getHobbies().size(), 1);
	}
	
	@Test
	public void checkEmptyTest() throws Exception{
		// create testing environment
		ObservableIUser user1 = new ObservableIUser("kevin", new HashSet<String>());
		IAdmin admin1 = new Admin();
		user1.addIUserObserver(admin1);
		
		assertEquals(admin1.getUpdateSet().size(), 0);
		assertEquals(admin1.getNumUpdates(), 0);
		
		
		// Predicate Form of Testing
		BiPredicate<ObservableIUser, IAdmin> p = 
				(user, admin) -> user.getHobbies().size() == admin.getUpdateSet().size();
				
		assertTrue(assertByBiPredicate(p, user1, admin1));
	}
	
	@Test
	public void checkMultipleTest() throws Exception{
		ObservableIUser user1 = new ObservableIUser("kevin", new HashSet<String>());
		IAdmin admin1 = new Admin();
		user1.addIUserObserver(admin1);
		
		user1.addHobby("Tennis");
		user1.addHobby("Basketball");
		user1.addHobby("Video Games");
		
		assertEquals(user1.getHobbies().size(), 3);
		
	}
}
