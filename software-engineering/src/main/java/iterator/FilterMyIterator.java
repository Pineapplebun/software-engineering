package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * A more flexible implementation of MyIterator using predicates such that
 * we can reuse this iterator to retrieve certain filtered results for an
 * input predicate condition.
 * 
 * I.e. Instead of size, the predicate could check for whether a List<T>
 * contains a T object with a specific property and return it.
 * 
 * @author kevin
 *
 * @param <T>
 */

public class FilterMyIterator<T> implements Iterator<List<T>> {
	
	private Iterator<List<T>> someIterator;
	private Predicate<List<T>> filter;
	private List<T> next;
	
	public FilterMyIterator(Iterator<List<T>> someIterator, Predicate<List<T>> filter) {
		this.someIterator = someIterator;
		this.filter = filter;
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
			if (filter.test(nextItem)) {
				return nextItem;
			}
		}
		return null;
	}
	
}
