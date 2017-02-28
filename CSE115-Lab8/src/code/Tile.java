	package code;

	import java.awt.Color;

	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.util.Random;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class Tile implements ActionListener {

	private JFrame _j;
	public Tile(JFrame frame){
	    _j = frame;
	}
	public void actionPerformed (ActionEvent e) {     

	    JFrame frame2 = new JFrame("Keybricks");


	    frame2.setVisible(true);
	    frame2.setSize(600,600);
	    
	    JPanel panel = new JPanel();
	    frame2.add(panel);
	           
	    _j.setVisible(true); //This creates a new game frame

	    GridLayout experimentLayout = new GridLayout(4,4);

	            panel.setLayout(experimentLayout);
	                      
	            ArrayList<Color> colors = new ArrayList<>();

	            colors.add(Color.RED);
	            colors.add(Color.BLUE);
	            colors.add(Color.GREEN);
	            colors.add(Color.YELLOW);

	            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	            ArrayList<Character> letters = new ArrayList<>(); 

	            for (char c : alphabet.toCharArray()) {
	                  letters.add(c);
	                }

	            Random rnd = new Random();
				
	//            char randomLetter = letters.get(rnd.nextInt(letters.size()));

	            
	            ArrayList<JButton> buttons = new ArrayList<>();
	            
	            for (int i = 0; i < 16; i++){
	                JButton jb = new JButton();
	                buttons.add(jb);
	                jb.addActionListener(new eventhandler(panel,jb));
	                panel.add(jb);
	               
	            }
	            
	 //           JButton randomJButton = buttons.get(rnd.nextInt(buttons.size()));
	           
	            for (JButton button : buttons){
	                Color randomColor = colors.get(rnd.nextInt(colors.size())); // Get a new random color
	                button.setBackground(randomColor);
	                button.setOpaque(true);
	            }
	                       
	            for(int j=0; j < 4; j++){
	            	
	            	JButton randbutton = buttons.get(rnd.nextInt(buttons.size()));
	            	char randletter = letters.get(rnd.nextInt(letters.size()));
	            	randbutton.setText(" " + randletter);
	            	
	            }
	            
	           

	            
	            	            
	            
	}
	}
