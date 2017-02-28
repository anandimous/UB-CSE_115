/**
 * 
 */
package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

/**
 * @author alphonce
 *
 */
public class NotEmptyVisitor<E> implements IAlgo<Boolean, E, Object> {
	@Override
	public Boolean emptyCase(LRStruct<E> host, Object _) {
		return false;
	}
	@Override
	public Boolean nonEmptyCase(LRStruct<E> host, Object _) {
		return true;
	}
}
