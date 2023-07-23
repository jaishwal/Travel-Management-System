package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;
    JButton login, signup, cancel;
    Login(){
        setSize(900, 400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(106, 174, 219));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
        p2.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBackground(new Color(106,174,219));
        login.setForeground(Color.WHITE);
        login.setBounds(60,200,130,30);
        login.setBorder(new LineBorder(new Color(106,174,219)));
        login.addActionListener(this);
        p2.add(login);

        cancel = new JButton("Signup");
        cancel.setBackground(new Color(106,174,219));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,200,130,30);
        cancel.setBorder(new LineBorder(new Color(106,174,219)));
        cancel.addActionListener(this);
        p2.add(cancel);

        signup = new JButton("Forget Password");
        signup.setBackground(new Color(106,174,219));
        signup.setForeground(Color.WHITE);
        signup.setBounds(130,240,150,30);
        signup.setBorder(new LineBorder(new Color(106,174,219)));
        signup.addActionListener(this);
        p2.add(signup);

        JLabel text = new JLabel("Trouble in login..");
        text.setBounds(320,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignUp();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
