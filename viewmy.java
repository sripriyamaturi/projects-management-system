import java.awt.Color;

import javax.swing.*;

//import javax.swing.table.DefaultTableModel;



public class viewmy {
	
	viewmy(int id){
	
		JFrame frame = new myprojects(id);
        frame.setTitle("My Projects");
        Color Blue = new Color(187, 255, 153);
		frame.getContentPane().setBackground(Blue);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	}
}
