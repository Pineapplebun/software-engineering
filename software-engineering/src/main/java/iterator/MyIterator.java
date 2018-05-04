package iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Example implementation of an Iterator using the Iterator Interface.
 * 
 * Return all List<T> whose sizes are greater than Integer size.
 * 
 * I.e. Useful if you want to retrieve a group of users of a certain
 * size. 
 * 
 * However, what if we wanted to be more flexible, say pick out
 * the Lists<T> that contain a T with a certain property instead of 
 * simply looking at the size of the list? Then we would need to create
 * another Iterator class just to do that, unless we use a functional
 * paradigm...
 * 
 * Benefits:
 * - Modularity: Less dependent on specific collections
 * - Convenience: 
 * - Clear Design: Only used for traversing in a specified way
 * @author kevin
 * @param <T>
 *
 * @param <T>
 */
public class MyIterator<T> implements Iterator<List<T>>{
	
	private Iterator<List<T>> someIterator;
	private int size;
	private List<T> next;
	
	public MyIterator(Iterator<List<T>> someIterator, int size) {
		this.someIterator = someIterator;
		this.size = size;
		this.next = this.findNext();
	}
	
	public boolean hasNext() {
		return this.next != null;
	}

	public List<T> next() {
		List<T> tmp = this.next;
		this.next = this.findNext();
		return tmp;
	}
	
	private List<T> findNext() {
		List<T> nextItem;
		while (someIterator.hasNext()) {
			nextItem = this.someIterator.next();
			if (nextItem.size() >= this.size) {
				return nextItem;
			}
		}
		return null;
	}

}
