package semplest.server.keyword;

import semplest.other.F;

public abstract class HasAKeyword {
	public abstract Keyword getKeyword();
	
	public static <A extends HasAKeyword> F<A, Keyword> toKeyword() {
		return new F<A, Keyword>() {
			
			@Override
			public Keyword apply(A a) {
				return a.getKeyword();
			}
		};
	}
}
