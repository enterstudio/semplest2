package semplest.other;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import semplest.other.Effect;
import semplest.other.Effect2;
import semplest.other.F;
import semplest.other.F2;
import semplest.other.Filter;
import semplest.other.Tuple;
import static semplest.other.Tuple.asTuple;

public class Lists {
	//TODO A should extend comparable
	public static <A> List<A> range(A from, A to, F<A, A> increment) {
		List<A> result = new ArrayList<A>();
		A curr = from;
		while (!curr.equals(to)) {
			result.add(curr);
			curr = increment.apply(curr);
		}
		result.add(to);
		return result;
	}
	
	public static <A, B> List<Tuple<A, B>> zip(List<A> list1, List<B> list2) {
		List<Tuple<A, B>> result = new ArrayList<Tuple<A, B>>();
		int n = list1.size() > list2.size() ? list2.size() : list1.size();
		for (int i = 0; i < n; i++) {
			result.add(asTuple(list1.get(i), list2.get(i)));
		}
		return result;
	}
	
	//TODO MAKE THIS WORK
	public static <A> List<A> range(A from, A to, F<A, A> increment, F2<A, A, Boolean> compare) {
		List<A> result = new ArrayList<A>();
		A curr = from;
		while (!curr.equals(to)) {
			result.add(curr);
			curr = increment.apply(curr);
		}
		result.add(to);
		return result;
	}
	
	public static <A, B> List<B> map(List<? extends A> from, F<A, B> f) {
		ArrayList<B> result = new ArrayList<B>();
		for (A a : from) {
			result.add(f.apply(a));
		}
		return result;
	}
	
	public static <A, B, C> List<C> map(List<? extends A> from1, List<? extends B> from2, F2<A, B, C> f) {
		ArrayList<C> result = new ArrayList<C>();
		int length = Math.min(from1.size(), from2.size());
		for (int i = 0; i < length; i++) {
			result.add(f.apply(from1.get(i), from2.get(i)));
		}
		return result;
	}
	
	public static <A, B> List<B> flatMap(List<? extends A> from, F<A, List<B>> f) {
		List<B> result = new ArrayList<B>();
		for (A a : from) {
			result.addAll(f.apply(a));
		}
		return result;
	}
	
	public static <A> A reduce(List<A> from, F2<A, A, A> f) {
		if (from.isEmpty()) {
			return null;
		}
		A acc = from.get(0);
		for (int i = 1; i < from.size(); i++) {
			A cur = from.get(i);
			acc = f.apply(acc, cur);
		}
		return acc;
	}
	
	public static <A> A reduce(List<A> from, A valueIfListIsEmpty, F2<A, A, A> f) {
		if (from.isEmpty()) {
			return valueIfListIsEmpty;
		}
		A acc = from.get(0);
		for (int i = 1; i < from.size(); i++) {
			A cur = from.get(i);
			acc = f.apply(acc, cur);
		}
		return acc;
	}
	
	public static <A> List<A> filter(List<A> from, Filter<A> f) {
		ArrayList<A> result = new ArrayList<A>();
		for (A a : from) {
			if (f.apply(a)) {
				result.add(a);
			}
		}
		return result;
	}
	
	public static <A> List<A> filter(List<A> from, List<? extends Filter<A>> filters) {
		List<Filter<A>> _filters = new ArrayList<Filter<A>>(filters);
		if (_filters.isEmpty()) {
			return from;
		}
		Filter<A> toFilter = _filters.get(0);
		_filters.remove(0);
		return filter(filter(from, toFilter), _filters);
	}
	
	public static <A> List<A> filter(List<A> from, Filter<A> f1, Filter<A> f2) {
		return filter(filter(from, f2), f1);
	}
	
	public static <A> List<A> interpose(List<A> list, A sep) {
		if (list.isEmpty()) {
			return list;
		}
		ArrayList<A> newList = new ArrayList<A>();
		for (A a : list) {
			newList.add(a);
			newList.add(sep);
		}
		newList.remove(newList.size() - 1);
		return newList;
	}
	
	//TODO stop at the end of the shorter one no ArrayIndexOutOfBoundsException please
	/**
	 * For side-effects
	 */
	public static <T, K> void foreach(List<T> colT, List<K> colK, Effect2<T, K> e) {
		for (int i = 0; i < colT.size(); i++) {
			e.apply(colT.get(i), colK.get(i));
		}
	}
	
	/**
	 * group a list according to a grouping function f:S->T. returned function maps
	 * each element of type T into the sublist of list that map to that element.
	 */
	public static <S, T> F<T, List<S>> groupBy(final List<S> list, final F<S, T> f) {
		final Map<T, List<S>> result = new HashMap<T, List<S>>();
		Effect<S> addToMap = new Effect<S>() {
			@Override
			public void apply(S a) {
				T key = f.apply(a);
				if (result.get(key) == null)
					result.put(key, new ArrayList<S>());
				result.get(key).add(a);
			}
		};
		Collections.foreach(list, addToMap);
		return new F<T, List<S>>() {
			@Override
			public List<S> apply(T a) {
				return result.get(a);
			}
		};
	}
	
	//TODO transform to regular for loop
	public static <A, B> List<A> setDifference(List<A> a, List<B> b, F2<A, B, Boolean> test) {
		ArrayList<A> difference = new ArrayList<A>();
		for (A aItem : a) {
			boolean found = false;
			for (B bItem : b) {
				found = test.apply(aItem, bItem);
				if (found) {
					break;
				}
			}
			if (!found) {
				difference.add(aItem);
			}
		}
		return difference;
	}
	
	/**
	 * This will return items from List a
	 */
	//TODO use regular for loop
	public static <A> List<A> intersection(List<A> a, List<A> b, F2<A, A, Boolean> test) {
		ArrayList<A> intersection = new ArrayList<A>();
		for (A aItem : a) {
			for (A bItem : b) {
				if (test.apply(aItem, bItem)) {
					intersection.add(aItem);
					continue;
				}
			}
		}
		return intersection;
	}
	
	//TODO use regular for loop
	public static <A, B> List<Tuple<A, B>> intersectionWithTuples(List<A> a, List<B> b, F2<A, B, Boolean> test) {
		ArrayList<Tuple<A, B>> intersection = new ArrayList<Tuple<A, B>>();
		for (A aItem : a) {
			for (B bItem : b) {
				if (test.apply(aItem, bItem)) {
					intersection.add(new Tuple<A, B>(aItem, bItem));
					continue;
				}
			}
		}
		return intersection;
	}
	
	public static <A> A head(List<A> list) {
		if (list == null || list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
	public static <A> List<A> tail(List<A> list) {
		List<A> result = null;
		if (list != null) {
			result = new ArrayList<A>(list);
			if (!result.isEmpty())
				result.remove(0);
			if (list.isEmpty())
				result = new ArrayList<A>();
		}
		return result;
	}
	
	public static <A, B> B foldLeft(B start, List<A> list, F2<B, A, B> f) {
		List<A> stuff = list;
		B val = start;
		while (!stuff.isEmpty()) {
			val = f.apply(val, head(stuff));
			stuff = tail(stuff);
		}
		return val;
	}
	
	public static <A> List<A> removeDuplicates(List<A> list) {
		F2<List<A>, A, List<A>> accumulate = new F2<List<A>, A, List<A>>() {
			@Override
			public List<A> apply(List<A> list, A a) {
				// note: the point of this function is to accumulate stuff in list.  for convenience/speed, we assume it's mutable and just modify/return it (vs. copying)
				if (!list.contains(a))
					list.add(a);
				return list;
			}
		};
		List<A> result = new ArrayList<A>();
		result = foldLeft(result, list, accumulate);
		return result;
	}
	
	public static <A> List<A> removeDuplicates(List<A> list, final F2<A, A, Boolean> equalityTest) {
		F2<List<A>, A, List<A>> accumulate = new F2<List<A>, A, List<A>>() {
			@Override
			public List<A> apply(List<A> list, A a) {
				boolean found = false;
				for (A item : list) {
					if (equalityTest.apply(item, a)) {
						found = true;
					}
				}
				if (!found) {
					list.add(a);
				}
				return list;
			}
		};
		List<A> result = new ArrayList<A>();
		result = foldLeft(result, list, accumulate);
		return result;
	}
}
