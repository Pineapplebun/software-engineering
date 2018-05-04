package iterator;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Given some Iterator of R objects and a function that maps R -> T,
 * return the corresponding T object.
 * 
 * I.e. Given a User object and a function that maps User -> Location
 * return the Location object associated with User.
 * 
 * An example mappingFunction is
 * Function<R,T> f = (R, T) -> someFunction(R,T)
 * 
 * @author kevin
 *
 * @param <R>
 * @param <T>
 */

public class MappingIterator<R,T> implements Iterator<T>{
	
	private Iterator<R> someIterator;
	private Function<R,T> mappingFunction;
	
	public MappingIterator(Iterator<R> someIterator, Function<R,T> mappingFunction) {
		this.someIterator = someIterator;
		this.mappingFunction = mappingFunction;
	}
	
	public boolean hasNext() {
		return this.someIterator.hasNext();
	}

	public T next() {
		return this.mappingFunction.apply(this.someIterator.next());
	}

}
