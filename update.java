import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class update
{
    JFrame frame = new JFrame("Update/Score Project");

    JLabel heading = new JLabel("UPDATE PROJECT");

    JLabel pId = new JLabel("Enter Student id : ");
    JLabel pName = new JLabel("Enter project name : ");
    JLabel stock = new JLabel("Enter Description : ");
    JLabel price = new JLabel("Enter Date : ");
    JLabel type = new JLabel("Enter Course : ");
    JLabel brand = new JLabel("Enter Code(link) : ");
    JLabel description = new JLabel("Enter score : ");
    JLabel go_to = new JLabel("GOTO");


    List ids = new List(15);

    JTextField tpId = new JTextField();
    JTextField tpName = new JTextField();
    JTextField tStock = new JTextField();
    JTextField tPrice = new JTextField();
    JTextField tType = new JTextField();
    JTextField tBrand = new JTextField();
    JTextField tDescription = new JTextField();
    
    JTextArea resultText = new JTextArea();
    
    JButton home = new JButton("Home");
    JButton update = new JButton("MODIFY");
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

    public update(){
    	
    	connDb();
        loadProducts();

        ids.setBounds(50, 100, 200, 350);
        heading.setBounds(150, 50, 100, 20);
        pId.setBounds(300, 100, 100, 30);
        pName.setBounds(300, 150, 200, 30);
        tpId.setBounds(450, 100, 150, 30); //1
       	tpName.setBounds(450, 150, 150, 30);//2
        stock.setBounds(300, 200, 150, 30);
        tStock.setBounds(450, 200, 150, 30);//3
        price.setBounds(300, 250, 150, 30);
        tPrice.setBounds(450, 250,150, 30);//4
        brand.setBounds(300, 300, 150, 30);
        tBrand.setBounds(450, 300, 150, 30);//5
        type.setBounds(300, 350, 150, 30);
        tType.setBounds(450, 350, 150, 30);//6
        description.setBounds(300, 400, 150, 30);
        tDescription.setBounds(450, 400, 150, 30);//7
        resultText.setBounds(300, 450, 200, 150);
        
        update.setBounds(50, 470, 100, 30);
        go_to.setBounds(50, 500, 100, 30);
        home.setBounds(50, 550, 100, 30);
        back.setBounds(50, 600, 100, 30);
        
        Color Blue = new Color(187, 255, 153);
		frame.getContentPane().setBackground(Blue);

        frame.add(ids);
        frame.add(heading);
        frame.add(pId);
        frame.add(pName);
        frame.add(tpId);
        frame.add(tpName);
        frame.add(stock);
        frame.add(price);
        frame.add(brand);
        frame.add(type);
        frame.add(description);
        frame.add(tStock);
        frame.add(tPrice);
        frame.add(tBrand);
        frame.add(tType);
        frame.add(tDescription);
        frame.add(update);
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
                    rs = stmt.executeQuery("SELECT * FROM projects where ID ="+ids.getSelectedItem());
                    rs.next();
                    tpId.setText(rs.getString(1));
                    tpName.setText(rs.getString(2));
                    tStock.setText(rs.getString(3));
                    tPrice.setText(rs.getString(4));
                    tType.setText(rs.getString(6));
                    tBrand.setText(rs.getString(5));
                    tDescription.setText(rs.getString(7));

                } 
                catch (SQLException selectException) 
                {
                    displaySQLErrors(selectException);
                }
        }});

        update.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try 
                {   

//                    Statement statement = con.createStatement();
                    int i = stmt.executeUpdate("UPDATE projects "
                    + "SET ID=" + tpId.getText() + ", "
                    + "PNAME='" + tpName.getText() + "', "
                    + "descript= '" + tStock.getText() + "', "
                    + "dat='" + tPrice.getText() + "', "
                    + "Course='" + tBrand.getText() + "', "
                    + "code='" + tType.getText() + "', "
                    + "score ="+ tDescription.getText() + " WHERE id = "
                    + ids.getSelectedItem());
                    
                    resultText.append("\nUpdated " + i + " rows successfully");
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
               //new admChoice();
               // new clickListener();
            
           }});
   
    }   
}




