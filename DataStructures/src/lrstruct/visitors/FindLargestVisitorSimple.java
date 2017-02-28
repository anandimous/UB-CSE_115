package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class FindLargestVisitorSimple implements IAlgo<Integer, Integer, Integer> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Integer hypothesis) {
		System.out.println("Done: largest is: "+hypothesis);
		return hypothesis;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Integer hypothesis) {
		int newHypothesis = Math.max(host.getDatum(), hypothesis);
		System.out.println("largest so far: "+newHypothesis+", rest of list is "+host.getRest());
		return host.getRest().execute(this, newHypothesis);
	}

}
