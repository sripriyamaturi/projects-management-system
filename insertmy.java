import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class insertmy
{
    JFrame frame = new JFrame("Insert");

    JLabel heading = new JLabel("ADD MY PROJECT");

    JLabel Id = new JLabel("Enter id of student : ");
    JLabel pName = new JLabel("Enter project name :");
    JLabel des = new JLabel("Description : ");
    JLabel dat = new JLabel("Date : ");
    JLabel course = new JLabel("Enter Course : ");
    JLabel code = new JLabel("Code(link) : ");
    JLabel score = new JLabel("Enter the score: ");
    JLabel go_to = new JLabel("GOTO");

    JTextField tpId = new JTextField();
    JTextField tpName = new JTextField();
    JTextField tscore = new JTextField();
    JTextField date = new JTextField();
    JTextField tcourse = new JTextField();
    JTextField tcode = new JTextField();
    JTextField tDescription = new JTextField();
    
    JTextArea resultText = new JTextArea();
    
    JButton home = new JButton("Home");
    JButton insert = new JButton("Submit");
    JButton back = new JButton("Back");

    Statement stmt;
    
    public void connDb() {
    	try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
        
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@218.248.0.7:1521:rdbms","it19737018","vasavi");
            stmt = con.createStatement();
            System.out.println("connection successful");
//            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public insertmy(String name, int id){
    	
    	connDb();
    	
    	Color Blue = new Color(187, 255, 153);
		frame.getContentPane().setBackground(Blue);

        heading.setBounds(50, 50, 100, 20);
        Id.setBounds(50, 100, 130, 30);
    
        
        pName.setBounds(50, 150, 200, 30);
        tpId.setBounds(250, 100, 150, 30);
        tpId.setEditable(false); 
        
        tpId.setText(Integer.toString(id));  
       	tpName.setBounds(250, 150, 150, 30);
        des.setBounds(50, 200, 150, 30);
        tDescription.setBounds(250, 200, 150, 30);
        dat.setBounds(50, 250, 150, 30);
        date.setBounds(250, 250,150, 30);
        course.setBounds(50, 300, 150, 30);
        tcourse.setBounds(250, 300, 150, 30);
        code.setBounds(50, 350, 150, 30);
        tcode.setBounds(250, 350, 150, 30);
      //  score.setBounds(50, 400, 150, 30);
       // tscore.setBounds(250, 400, 150, 30);
        resultText.setBounds(250, 450, 200, 150);
        
        insert.setBounds(50, 450, 100, 30);
        go_to.setBounds(50, 500, 100, 30);
        home.setBounds(50, 550, 100, 30);
        back.setBounds(50, 600, 100, 30);

        frame.add(heading);
        frame.add(Id);
        frame.add(pName);
        frame.add(tpId);
        frame.add(tpName);
        frame.add(dat);
       frame.add(date);
        frame.add(des);
        frame.add(tDescription);
        frame.add(course);
        frame.add(tcourse);
        frame.add(code);
        frame.add(tcode);
       // frame.add(score);
       // frame.add(tscore);
        frame.add(insert);
        frame.add(go_to);
        frame.add(home); 
        frame.add(resultText);
        frame.add(back);
        
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(10, 10, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

        insert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
            
            try {			  
				  String query= "INSERT INTO projects VALUES(" + tpId.getText() + ",'" + tpName.getText() + "','" + tDescription.getText() + "','" + date.getText() + "','" + tcourse.getText() + "','" + tcode.getText() + "'," + tscore.getText() +" )"; 
				  int i = stmt.executeUpdate(query);
				  resultText.append("\nInserted " + i + " rows successfully");

           	 	//ResultSet rs = stmt.executeQuery(sql);          	 	
           	 	//while(rs.next()){
	             //    System.out.println(rs.getInt(1) + " " + rs.getString(2));
	                 
	            	 	      //       } 
            }
            catch(SQLException e){
                System.out.println(e);
            }
            

            // frame.dispose();
            // new customerLogin();
        }});

        home.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            new Gui();
            // new clickListener();
         
        }});
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               frame.dispose();
               new facultyopts(name);
               // new clickListener();
            
           }});
   
    }   
}