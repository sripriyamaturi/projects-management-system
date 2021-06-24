import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class delete
{
    JFrame frame = new JFrame("Delete Project");

    JLabel heading = new JLabel("DELETE PROJECT");

    JLabel Id = new JLabel("Enter id of student : ");
    JLabel pName = new JLabel("Enter project name :");
    JLabel des = new JLabel("Description : ");
    JLabel dat = new JLabel("Date : ");
    JLabel course = new JLabel("Enter Course : ");
    JLabel code = new JLabel("Code(link) : ");
    JLabel score = new JLabel("Enter the score: ");
    JLabel go_to = new JLabel("GOTO");


    List ids = new List(15);

    JTextField tpId = new JTextField();
    JTextField tpName = new JTextField();
    JTextField tscore = new JTextField();
    JTextField date = new JTextField();
    JTextField tcourse = new JTextField();
    JTextField tcode = new JTextField();
    JTextField tDescription = new JTextField();
    
    JTextArea resultText = new JTextArea();
    
    JButton home = new JButton("Home");
    JButton delete = new JButton("DELETE");
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

    public void loadProducts(){

        try 
        {
          ResultSet rs;
          rs = stmt.executeQuery("SELECT ID FROM projects");
          while (rs.next()) 
          {
            ids.add(rs.getString(1));
          }
        } 
        catch (SQLException e) 
        { 
          displaySQLErrors(e);
        }
    }
    private void displaySQLErrors(SQLException e) 
    {
        JOptionPane.showMessageDialog(frame,"Enter valid data types");  
        resultText.append("\nSQLException: " + e.getMessage() + "\n");
        resultText.append("SQLState:     " + e.getSQLState() + "\n");
        resultText.append("VendorError:  " + e.getErrorCode() + "\n");
    }

    public delete(String name){
    	
    	connDb();
        loadProducts();

//        heading.setBounds(50, 50, 100, 20);
//        Id.setBounds(50, 100, 130, 30);
//        pName.setBounds(50, 150, 200, 30);
//        tpId.setBounds(250, 100, 150, 30);
//       	tpName.setBounds(250, 150, 150, 30);
//        des.setBounds(50, 200, 150, 30);
//        tDescription.setBounds(250, 200, 150, 30);
//        dat.setBounds(50, 250, 150, 30);
//        date.setBounds(250, 250,150, 30);
//        course.setBounds(50, 300, 150, 30);
//        tcourse.setBounds(250, 300, 150, 30);
//        code.setBounds(50, 350, 150, 30);
//        tcode.setBounds(250, 350, 150, 30);
//        score.setBounds(50, 400, 150, 30);
//        tscore.setBounds(250, 400, 150, 30);
        
        ids.setBounds(50, 100, 200, 350);
        heading.setBounds(150, 50, 100, 20);
        Id.setBounds(300, 100, 100, 30);
        pName.setBounds(300, 150, 200, 30);
        tpId.setBounds(450, 100, 150, 30);
       	tpName.setBounds(450, 150, 150, 30);
        des.setBounds(300, 200, 150, 30);
        tDescription.setBounds(450, 200, 150, 30);
        dat.setBounds(300, 250, 150, 30);
        date.setBounds(450, 250,150, 30);
        course.setBounds(300, 300, 150, 30);
        tcourse.setBounds(450, 300, 150, 30);
        code.setBounds(300, 350, 150, 30);
        tcode.setBounds(450, 350, 150, 30);
        score.setBounds(300, 400, 150, 30);
        tscore.setBounds(450, 400, 150, 30);
        resultText.setBounds(300, 450, 300, 150);
   
      
        resultText.setBounds(300, 450, 300, 150);
        
        delete.setBounds(50, 470, 100, 30);
        go_to.setBounds(50, 500, 100, 30);
        home.setBounds(50, 550, 100, 30);
        back.setBounds(50, 600, 100, 30);
        
        Color Blue = new Color(187, 255, 153);
   		frame.getContentPane().setBackground(Blue);
        
        frame.add(ids);
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
        frame.add(score);
        frame.add(tscore);
        frame.add(delete);
        frame.add(go_to);
        frame.add(home); 
        frame.add(resultText);
        frame.add(back);
        
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(10, 10, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

        ids.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent ae) {
            
            try     
            {
            	    ResultSet rs;
                    rs = stmt.executeQuery("SELECT * FROM projects where ID ='"+ids.getSelectedItem()+"'");
                    rs.next();
                    tpId.setText(rs.getString(1));
                    tpName.setText(rs.getString(2));
                    tDescription.setText(rs.getString(3));
                    date.setText(rs.getString(4));
                    tcourse.setText(rs.getString(6));
                    tcode.setText(rs.getString(5));
                    tscore.setText(rs.getString(7));

                } 
                catch (SQLException selectException) 
                {
                    displaySQLErrors(selectException);
                }
        }});

        delete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try 
                {   
                    int i = stmt.executeUpdate("DELETE FROM projects WHERE ID = " + ids.getSelectedItem());                  
                    resultText.append("\nDeleted " + i + " rows successfully");
                    ids.removeAll();
                    loadProducts();
                } 
                catch (SQLException insertException) 
                {
                    displaySQLErrors(insertException);
                }   
         
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
              // new admChoice();
               // new clickListener();
               new facultyopts(name);
            
           }});
   
    }   
}

