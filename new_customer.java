import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.*;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    new_customer(){
        setLocation(350,200);
        setSize(650,600);
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));
        
        p.setBackground(Color.WHITE);
        
        l1 = new JLabel("Name");
        t1 = new JTextField();
        l1.setFont(new Font("TimesRoman",Font.PLAIN,20));
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        l2.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t2 = new JTextField();
        p.add(l2);
        p.add(t2);
        l3 = new JLabel("Address");
        l3.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("State");
        l4.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t4 = new JTextField();
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("City");
        l5.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t5 = new JTextField();
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Email ID");
        l6.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t6 = new JTextField();
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        l7.setFont(new Font("TimesRoman",Font.PLAIN,20));
        t7 = new JTextField();
        p.add(l7);
        p.add(t7);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/New.JPG"));
        Image i3 = ic1.getImage().getScaledInstance(200, 700,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole 
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
boolean isValidphone(String str)
	{
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(str); 
		return (match.find() && match.group().equals(str)); 
	}
    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String c = t2.getText();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();
        
        String q1 = "insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";
        if(!isValidphone(h)){
					JOptionPane.showMessageDialog(null,"Invalid Mobile Number.");
		}
		else{
			try{
				conn c1 = new conn();
				c1.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null,"New Customer Added");
				this.setVisible(false);
				
				
			}catch(Exception ex){
				 ex.printStackTrace();
			}
        }
    }
    
    
    public static void main(String[] args){
        new new_customer().setVisible(true);
    }
}