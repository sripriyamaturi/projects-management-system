

import java.awt.*;

import javax.swing.*;





public class viewall {
	
	viewall(){
	
		JFrame frame = new list();
		
        frame.setTitle("All Projects");
        

		Color Blue = new Color(187, 255, 153);
		frame.getContentPane().setBackground(Blue);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	}
}
