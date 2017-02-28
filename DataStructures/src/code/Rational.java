package code;

import java.math.BigInteger;

public class Rational {

	public static Rational ZERO = new Rational(0,1);
	public static Rational ONE = new Rational(1,1);
	
	private int _n;
	private int _d;
	
	public Rational(int n, int d) {
		if (d == 0) { throw new IllegalArgumentException("Denominator cannot be zero"); }
		if ( n<0 && d<0 ) { n*=-1; d*=-1; }
		if ( !(n<0) && (d<0) ) { n*=-1; d*=-1; }
		_n = n;
		_d = d;
		reduce();
	}
	
	@Override public String toString() { return _n+"/"+_d; }
	
	private void reduce() {
		BigInteger x = new BigInteger(""+_n);
		BigInteger y = new BigInteger(""+_d);
		BigInteger z = x.gcd(y);
		_n = _n / z.intValue();
		_d = _d / z.intValue();
	}

	public Rational neg() {
		return new Rational(-this._n,this._d);
	}

	public Rational add(Rational that) {
		return new Rational(this._n*that._d + that._n*this._d,this._d*that._d);
	}

	public Rational sub(Rational that) {
		return this.add(that.neg());
	}

	public Rational rec() {
		return new Rational(this._d,this._n);
	}
	
	public Rational mul(Rational that) {
		return new Rational(this._n*that._n,this._d*that._d);
	}
	
	public Rational div(Rational that) {
		return this.mul(that.rec());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==null) { return false; }
		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}
		Rational that = (Rational) obj;
		return this._n == that._n && this._d == that._d;
	}
	
	

}
