package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    ViewPackage(String username){
        setBounds(450,220,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,70,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,70,150,25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,110,150,25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,110,150,25);
        add(labelpackage);

        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30,150,150,25);
        add(lblperson);

        JLabel labelperson = new JLabel();
        labelperson.setBounds(220,150,150,25);
        add(labelperson);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,190,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,190,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,230,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,230,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,270,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,270,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,310,150,25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,310,150,25);
        add(labelprice);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,450,400);
        add(image);


        try{
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("total_price"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);

        }
    }

    public static void main(String[] args) {

        new ViewPackage("sonu123");
    }
}
