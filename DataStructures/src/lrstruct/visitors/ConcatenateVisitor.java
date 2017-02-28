package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ConcatenateVisitor implements IAlgo<String,String,Void> {

	@Override public String emptyCase(LRStruct<String> host, Void __) {
		return ""; 
	}

	@Override public String nonEmptyCase(LRStruct<String> host, Void __) {
		return host.getDatum() + host.getRest().execute(this, __);
	}
}
