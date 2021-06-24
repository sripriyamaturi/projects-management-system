//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class studentopts{

		private JFrame f = new JFrame("Student");
		private JButton all = new JButton("View All Projects");  
		private JButton my = new JButton("View my projects");
		private JButton insert = new JButton("Add my project");  
		private JButton search = new JButton("Search for a Project");
		//private JButton modify = new JButton("Modify a Project");  
		//private JLabel name = new JLabel()


	public studentopts(String name, int id){

		all.setBounds(30, 130, 220,30);
		my.setBounds(30, 170, 220, 30);
		insert.setBounds(30,210,220,30);
		search.setBounds(30,250,220,30);
	//	modify.setBounds(200, 140, 80, 30);
		

		Color Blue = new Color(187, 255, 153);
		f.getContentPane().setBackground(Blue);

		JLabel label = new JLabel("Hi, " + name);
		
		JLabel menu = new JLabel("MENU");
		menu.setBounds(125, 60, 80,30);
		f.add(menu);
		
		label.setBounds(110,24, 80, 30);
		f.add(label);

		f.add(all);
		f.add(my);
		f.add(search);
		f.add(insert);
		//f.add(modify);


		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,400);
		f.setVisible(true);  
		
		
		all.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new viewall();    
            }  
        });
		
		insert.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new insertmy(name, id);    
            }  
        });
		my.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new viewmy(id);    
            }  
        });
		
		search.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
               	f.dispose();
        		new search();    
            }  
        });
	}
}