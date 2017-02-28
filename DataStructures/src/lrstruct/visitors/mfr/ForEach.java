package lrstruct.visitors.mfr;

import functions.Function;
import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ForEach<E> implements IAlgo<Void, E, Function<E>> {

	@Override public Void emptyCase(LRStruct<E> host, Function<E> _) {
		return null;
	}

	@Override public Void nonEmptyCase(LRStruct<E> host, Function<E> f) {
		host.setDatum(f.apply(host.getDatum()));
		host.getRest().execute(this,f);
		return null;
	}
}
