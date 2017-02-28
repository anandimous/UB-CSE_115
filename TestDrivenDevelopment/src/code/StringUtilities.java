package code;

public class StringUtilities {

	public String reverse(String input) {
		// Blake's code
		if (input == null) {return null;}
		if (input.length() <= 1) {return input;}
		return reverse(input.substring(1)) + input.charAt(0);
	}

	// Dan's code
//	if(input != null){
//		String s = "";
//		for(int i = input.length() -1; i >= 0; i-- ){
//			char character = input.charAt(i);
//			s += character;
//		}
//		return s;
//	}
//	else{
//	return null;
//	}

//	if(input != null){
//		String s = "";
//		for(int i = 0; i < input.length(); i=i+1 ){
//			char character = input.charAt(i);
//			s = character + s;
//		}
//		return s;
//	}
//	else{
//	return null;
//	}

}
