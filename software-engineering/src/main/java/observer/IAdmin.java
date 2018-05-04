package observer;

import java.util.Set;

/**
 * An example of code craftsmanship. Since we require that 
 * Admin should be an observer we need to implement IUserObserver
 * somewhere. We also don't want to be hindered by only having 
 * the methods of IUserObserver since we want other special methods
 * that an Administrator should have, say IAdmin methods. So here
 * we have IAdmin extend IUserObserver so that we can use an 
 * implemented concrete class Admin to have both properties when
 * instantiated and declared as an IAdmin.
 *  
 * @author kevin
 *
 */

public interface IAdmin extends IUserObserver{
	
	public int getNumUpdates();
	public Set<IUser> getUpdateSet();
}
