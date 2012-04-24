package semplest.other;

import java.util.Collection;
import static semplest.other.Maybe.just;
import static semplest.other.Maybe.nothing;

public class Collections {
	
	/**
	 * For side-effects
	 */
	public static <A> void foreach(Collection<A> col, Effect<A> effect) {
		for (A a : col) {
			effect.apply(a);
		}
	}
	
	public static <A> Maybe<A> findFirstMatch(Collection<A> from, F<A, Boolean> f) {
		for (A a : from) {
			if (f.apply(a)) {
				return just(a);
			}
		}
		return nothing();
	}
	
	public static <A> Boolean exists(Collection<A> collection, F<A, Boolean> f) {
		for (A a : collection) {
			if (f.apply(a)) {
				return true;
			}
		}
		return false;
	}
	
}
