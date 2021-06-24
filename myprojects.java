import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class myprojects extends JFrame {
	 DefaultTableModel model = new DefaultTableModel();
	    Container cnt = this.getContentPane();
	    JTable jtbl = new JTable(model);
	    public myprojects(int id) {
	        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
	        model.addColumn("ID");
	        model.addColumn("Project name");
	        model.addColumn("Description");
	        model.addColumn("Date");
	        model.addColumn("Course");
	        model.addColumn("Code");
	        model.addColumn("Score");
	        //model.addColumn("Create");
	        String dburl ="jdbc:oracle:thin:@218.248.07:1521:rdbms";
			String us = "it19737018";
			String pas ="vasavi";
	        try {
	        	Connection  conn=DriverManager.getConnection(dburl,us,pas);
				System.out.println("Connected");
	           // Class.forName("com.mysql.jdbc.Driver");
	            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_db", "root", "");
	            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM projects where id = "+id);
	            ResultSet Rs = pstm.executeQuery();
	            while(Rs.next()){
	                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getInt(7)});
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        JScrollPane pg = new JScrollPane(jtbl);
	        cnt.add(pg);
	        this.pack();
	    }
}