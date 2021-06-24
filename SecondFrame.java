// SecondFrame.java
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SecondFrame {
	private JFrame f = new JFrame("Student Login");
	//JPanel panel = new JPanel();
	private JLabel l1 = new JLabel("Welcome!!");
	private JLabel l2 = new JLabel("Password: ");
	private JLabel l3 = new JLabel("User ID: ");
	private TextField id = new TextField();
	private JPasswordField value = new JPasswordField();  
	private   JButton b = new JButton("Login");
	private JLabel go = new JLabel("GOTO: ");
	private JButton h = new JButton("Home");  
	
	

	public SecondFrame() {
		l1.setBounds(120,20,80,30);

		l3.setBounds(20,60, 80,30);    
		l2.setBounds(20, 110, 80,30);
		id.setBounds(100,60,100,30);
    	value.setBounds(100,110,100,30);   
		b.setBounds(120, 160, 80, 30);
		go.setBounds(5,210, 80, 30);
		h.setBounds(100,210,100, 30);
		
		Color Blue = new Color(187, 255, 153);
		f.getContentPane().setBackground(Blue);


		
		// l2.setBounds(20,100, 80,30);
		// value.setBounds(100,100,100,30); 
		f.add(l1);   
		f.add(l2);
		f.add(value);
		f.add(b);
		f.add(l3);
		f.add(id);
		f.add(go);
		f.add(h);

		//f.add(panel);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setVisible(true);

	

		h.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {       
                   	f.dispose();
            		new Gui();    
                }  
            });

		b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
        	String userName = id.getText();
        	char[] temp_pwd=value.getPassword();
            String pwd=null;
            pwd=String.copyValueOf(temp_pwd);
           // String password = value.getText();
            String dburl ="jdbc:oracle:thin:@218.248.07:1521:rdbms";
    		String us = "it19737018";
    		String pas ="vasavi";
            try {
            	Connection  conn=DriverManager.getConnection(dburl,us,pas);
    			System.out.println("Connected");
    			
 
    			
    				Statement stmt =conn.createStatement();
    	            String sql = "select * from login where id ="+ userName;
    	            try {
    	           	 	ResultSet rs = stmt.executeQuery(sql);
    	           	 	
    		            while(rs.next()){
    		                 System.out.println(rs.getInt(1) + " " + rs.getString(2));
    		                 //System.out.println(pwdText);
    		                 if(rs.getString(3).equals(pwd)) {
    		                	 JOptionPane.showMessageDialog(f, "Login Successful");
    		                	 String abc = rs.getString(2);
    		                	 int id = rs.getInt(1);
    		                	 f.dispose();
    		                	 new studentopts(abc, id);
    		                 }
    		                 else {
    		                	 JOptionPane.showMessageDialog(f, "Invalid Username or Password");
    		                 }
    		            	 
    		             } 
    	            }
    	            catch(SQLException e){
    	                System.out.println(e);
    	            }
    	            

            } 
    			catch (SQLException sqlException) {
               sqlException.printStackTrace();
           }
        }});
	}
}