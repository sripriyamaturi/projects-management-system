import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class facultyopts{

		private JFrame f = new JFrame("Faculty");
		private JButton add = new JButton("Add a Project");  
		private JButton modify = new JButton("Score/modify a project");
		private JButton delete = new JButton("Delete a Project");  
		//private JLabel name = new JLabel()


	public facultyopts(String name){

		add.setBounds(30, 130, 220,30);
		modify.setBounds(30, 170, 220, 30);
		delete.setBounds(30, 210, 220, 30);
		
		Color Blue = new Color(187, 255, 153);
		f.getContentPane().setBackground(Blue);

		JLabel label = new JLabel("Hi, " + name);
		
		JLabel menu = new JLabel("MENU");
		menu.setBounds(125, 80, 80,30);
		f.add(menu);
		
		label.setBounds(115,24, 80, 30);
		f.add(label);

		f.add(add);
		f.add(modify);
		f.add(delete);


		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setVisible(true); 
		
		add.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new insert(name);    
            }  
        });
		
		delete.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new delete(name);    
            }  
        });
		
		modify.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new update();    
            }  
        });
		
		
		
	}
}