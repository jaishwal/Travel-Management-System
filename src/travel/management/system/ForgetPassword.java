package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){

        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150,25);
        tfusername.setBackground(Color.WHITE);
        tfusername.setForeground(Color.BLACK);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.GRAY);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150,25);
        tfname.setBackground(Color.WHITE);
        tfname.setForeground(Color.BLACK);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel question = new JLabel("Security Question");
        question.setBounds(40,100,150,25);
        question.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(question);

        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150,25);
        tfquestion.setBackground(Color.WHITE);
        tfquestion.setForeground(Color.BLACK);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,140,150,25);
        answer.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(answer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150,25);
        tfanswer.setBackground(Color.WHITE);
        tfanswer.setForeground(Color.BLACK);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380,140,100,25);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBackground(Color.GRAY);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(40,180,150,25);
        password.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(password);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150,25);
        tfpassword.setBackground(Color.WHITE);
        tfpassword.setForeground(Color.BLACK);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(160,240,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
