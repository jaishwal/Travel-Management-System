package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;
    ViewBookedHotel(String username){
        setBounds(450,220,900,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,70,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,70,150,25);
        add(labelusername);

        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30,110,150,25);
        add(lblhotel);

        JLabel labelhotel = new JLabel();
        labelhotel.setBounds(220,110,150,25);
        add(labelhotel);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(30,150,150,25);
        add(lblperson);

        JLabel labelperson = new JLabel();
        labelperson.setBounds(220,150,150,25);
        add(labelperson);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,190,150,25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,190,150,25);
        add(labeldays);

        JLabel lblac = new JLabel("AC Included?");
        lblac.setBounds(30,230,150,25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(220,230,150,25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30,270,150,25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,270,150,25);
        add(labelfood);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,310,310,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,310,310,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,350,150,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,350,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,390,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,390,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30,430,150,25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,430,150,25);
        add(labelprice);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,470,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,450,500);
        add(image);


        try{
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelhotel.setText(rs.getString("h_name"));
                labelperson.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
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

        new ViewBookedHotel("");
    }
}
