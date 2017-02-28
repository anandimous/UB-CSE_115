package lrstruct.visitors.mfr;

import functions.UnaryFunction;
import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class Map<O,E> implements IAlgo<LRStruct<O>, E, UnaryFunction<O,E>> {

	@Override public LRStruct<O> emptyCase(LRStruct<E> host, UnaryFunction<O,E> f) {
		return new LRStruct<O>();
	}

	@Override public LRStruct<O> nonEmptyCase(LRStruct<E> host, UnaryFunction<O,E> f) {
		LRStruct<O> answerForRest = host.getRest().execute(this,f);
		O answerForDatum = f.apply(host.getDatum());
		return answerForRest.insertFront(answerForDatum);
	}
	
}
