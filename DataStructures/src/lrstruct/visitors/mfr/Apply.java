package lrstruct.visitors.mfr;

import functions.UnaryFunction;
import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class Apply<O,E> implements IAlgo<LRStruct<E>, E, UnaryFunction<E,E>> {

	@Override public LRStruct<E> emptyCase(LRStruct<E> host, UnaryFunction<E,E> _) {
		return host;
	}

	@Override public LRStruct<E> nonEmptyCase(LRStruct<E> host, UnaryFunction<E,E> f) {
		host.setDatum(f.apply(host.getDatum()));
		host.getRest().execute(this,f);
		return host;
	}
}
