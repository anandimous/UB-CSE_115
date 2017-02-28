package utility;

import java.util.Arrays;

public class Sample {
	
	public static void main(String[] args) {
//		int size = 2;
//		JFrame f = new JFrame();
//		JPanel p = new JPanel();
//		GridLayout gl = new GridLayout(size,size,2,2);
//		f.add(p);
//		p.setLayout(gl);
//		for (int i=0; i<size; i++) {
//			for (int j=0; j<size; j++) {
//				JButton b = new JButton("!");//"("+i+","+j+")");
//				b.setBorder(new EmptyBorder(1, 1, 1, 1));
//				b.setMinimumSize(new Dimension(2,2));
//				p.add(b);
//				b.setBackground(Color.RED);
//				b.setOpaque(true);
//			}			
//		}
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.pack();
//		f.setVisible(true);
		
		int a[] = {1,3,5,7,9};
		System.out.println(Arrays.toString(a));
		for (int x : a) {
			x = x + 2;
			System.out.println("x is " + x);
		}
		System.out.println(Arrays.toString(a));
		
	}

}
