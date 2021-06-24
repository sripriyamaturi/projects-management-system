import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class home{
   public static void main(String[] args) {
      new Gui();
   }
}

class Gui
{
   
   public Gui(){
      JFrame frame = new JFrame("Home");
      //JPanel panel = new JPanel();
      
    //  Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
     // Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

    //  Color lightBlue = new Color(164, 206, 237);
      Color Blue = new Color(187, 255, 153);

      JLabel heading = new JLabel("COLLEGE PROJECTS MANAGEMENT SYSTEM");
      heading.setBounds(15,30,290,30);
      frame.add(heading);
  //    heading.setFont(f1);
      frame.getContentPane().setBackground(Blue);

      JLabel lb = new JLabel("Login as : ");
      lb.setBounds(110, 70,80,30);

      JButton button1 = new JButton("Student");
      button1.setBounds(50,110,80,30);    
      
      JButton button2 = new JButton("Faculty");
      button2.setBounds(150,110,80,30);



      frame.add(heading); 
      frame.add(lb);
      frame.add(button1);
      frame.add(button2);

      //frame.add(panel);

      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            new SecondFrame();
         }
      });

      button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            new clickListener();
         }
      });

      // ActionListener listener = new clickListener();
      // button1.addActionListener(listener);
      // ActionListener listener2 = new clickListener();
      // button2.addActionListener(listener2);

      //panel.setBackground(Color.cyan);
      frame.setLayout(null);

      frame.setSize(300, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }


}