package semplest.other;

import static com.google.common.collect.Iterators.emptyIterator;
import static com.google.common.collect.Iterators.singletonIterator;

import java.util.Iterator;
import java.util.List;

/**
 * taken from http://groups.google.com/group/growing-object-oriented-software/files
 * 
 * @author natpryce
 */
public abstract class Maybe<T> implements Iterable<T> {
	public abstract boolean isEmpty();
	
	public boolean contains(T value) {
		return !isEmpty() && iterator().next().equals(value);
	}
	
	public static <T> Maybe<T> just(final T thing) {
		return new JustOneValue<T>(thing);
	}
	
	public static <T> Maybe<T> nothing() {
		return new Maybe<T>() {
			@Override
			public Iterator<T> iterator() {
				return emptyIterator();
			}
			
			@Override
			public String toString() {
				return "";
			}
			
			@Override
			public boolean equals(Object obj) {
				return false;
			}
			
			@Override
			public int hashCode() {
				return super.hashCode();
			}
			
			@Override
			public boolean isEmpty() {
				return true;
			}
		};
	}
	
	private static class JustOneValue<T> extends Maybe<T> {
		private final T thing;
		
		public JustOneValue(T thing) {
			this.thing = thing;
		}
		
		@Override
		public Iterator<T> iterator() {
			return singletonIterator(thing);
		}
		
		@Override
		public String toString() {
			return thing.toString();
		}
		
		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if ((o == null) || (getClass() != o.getClass())) {
				return false;
			}
			
			JustOneValue that = (JustOneValue) o;
			
			return this.thing.equals(that.thing);
			
		}
		
		@Override
		public int hashCode() {
			return thing.hashCode();
		}
		
		@Override
		public boolean isEmpty() {
			return false;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addTo(List incoming) {
		for (T t : this) {
			incoming.add(t);
		}
	}
	
	//Yikes
	public T get() {
		return iterator().next();
	}
	
	public T otherwise(T t) {
		if (isEmpty()) {
			return t;
		}
		return get();
	}
	
	public <E extends Exception> T otherwiseException(E e) throws E {
		if (isEmpty()) {
			throw e;
		}
		return get();
	}
}
