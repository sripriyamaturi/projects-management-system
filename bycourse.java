import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  



public class bycourse{  
//Initializing Components  
	
	private JFrame f = new JFrame("Search by Course");
    JLabel lb, lb1, lb2, lb3, lb4, lb5;  
    JTextField tf1, tf2, tf3, tf4, tf5;  
    JButton btn;  
    //Creating Constructor for initializing JFrame components  
    bycourse() {  
        //Providing Title  
    	
    	Color Blue = new Color(187, 255, 153);
		f.getContentPane().setBackground(Blue);
       
        lb5 = new JLabel("Enter Course:");  
        lb5.setBounds(20, 20, 100, 20);  
        tf5 = new JTextField(20);  
        tf5.setBounds(130, 20, 200, 20);  
        btn = new JButton("Submit");  
        btn.setBounds(50, 50, 100, 20);  
      //  btn.addActionListener(this);  
        lb = new JLabel("Fetching Project Information");  
        lb.setBounds(30, 80, 450, 30);  
       // lb.setForeground(Color.red);  
        lb.setFont(new Font("Serif", Font.BOLD, 20));  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setSize(500, 500);  
        lb1 = new JLabel("ID:");  
        lb1.setBounds(20, 120, 100, 20);  
        tf1 = new JTextField(50);  
        tf1.setBounds(130, 120, 200, 20);  
        lb2 = new JLabel("Project Name:");  
        lb2.setBounds(20, 150, 100, 20);  
        tf2 = new JTextField(100);  
        tf2.setBounds(130, 150, 200, 20);  
        lb3 = new JLabel("Description:");  
        lb3.setBounds(20, 180, 100, 20);  
        tf3 = new JTextField(50);  
        tf3.setBounds(130, 180, 200, 20);  
        lb4 = new JLabel("Date:");  
        lb4.setBounds(20, 210, 100, 20);  
        tf4 = new JTextField(50);  
        tf4.setBounds(130, 210, 100, 20);  
        f.setLayout(null);  
        //Add components to the JFrame  
        f.add(lb5);  
        f.add(tf5);  
        f.add(btn);  
        f.add(lb);  
        f.add(lb1);  
        f.add(tf1);  
        f.add(lb2);  
        f.add(tf2);  
        f.add(lb3);  
        f.add(tf3);  
        f.add(lb4);  
        f.add(tf4);  
        //Set TextField Editable False  
        tf1.setEditable(false);  
        tf2.setEditable(false);  
        tf3.setEditable(false);  
        tf4.setEditable(false);  
        
        btn.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	
            	String dburl ="jdbc:oracle:thin:@218.248.07:1521:rdbms";
        		String us = "it19737018";
        		String pas ="vasavi";
            	
            	 //Create DataBase Coonection and Fetching Records  
                try {  
                    String str = tf5.getText();  
                    Connection  conn=DriverManager.getConnection(dburl,us,pas);
        			System.out.println("Connected");
        			
     
        			
        			//Statement stmt =conn.createStatement(); 
                    PreparedStatement st = conn.prepareStatement("select * from projects where course=?");  
                    st.setString(1, str);  
                    //Excuting Query  
                    ResultSet rs = st.executeQuery();  
                    if (rs.next()) {  
                        String s = rs.getString(1);  
                        String s1 = rs.getString(2);  
                        String s2 = rs.getString(3);  
                        String s3 = rs.getString(4); 
                        
                        //Sets Records in TextFields.  
                        tf1.setText(s);  
                        tf2.setText(s1);  
                        tf3.setText(s2);  
                        tf4.setText(s3);  
                    } else {  
                        JOptionPane.showMessageDialog(null, "Name not Found");  
                    }  
                    //Create Exception Handler  
                } catch (Exception ex) {  
                    System.out.println(ex);  
                }  
               	
            }  
        });
    }  
    
   
}  
