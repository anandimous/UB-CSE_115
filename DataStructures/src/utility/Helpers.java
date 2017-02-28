package utility;

public class Helpers {
	public static <E> String array2String(E[] array) { return array2String(array,0,array.length); }
	
	public static <E> String array2String(E[] array, int start, int end) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i=start; i<end; i++) {
			sb.append(" ");
			sb.append(array[i]);
		}
		sb.append(" ]");
		return sb.toString();
	}
}
