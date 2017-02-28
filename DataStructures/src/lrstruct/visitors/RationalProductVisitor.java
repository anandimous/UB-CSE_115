package lrstruct.visitors;

import code.Rational;
import lrstruct.LRStruct;

public class RationalProductVisitor implements LRStruct.IAlgo<Rational, Rational, Object>{

	@Override public Rational emptyCase(LRStruct<Rational> host, Object __) {
		return Rational.ONE;
	}

	@Override public Rational nonEmptyCase(LRStruct<Rational> host, Object __) {
	      Rational r = host.getDatum();
	      Rational s = host.getRest().execute(this,__);
	      Rational t = r.mul(s);
	      return t;
//		
//		return host.getDatum().mul(host.getRest().execute(this,__));
	}

}
