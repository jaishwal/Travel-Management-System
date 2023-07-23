package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    JLabel labelusername, labelid,labelnumber,labelphone,labeltotal;
    JButton checkprice, bookpackage, back;
    String username ;
    BookHotel(String username){
        this.username = username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,200,20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250,70,200,25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);


        JLabel lblhotel = new JLabel("Select Hotel");
        lblhotel.setBounds(40,110,200,20);
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblhotel);

        chotel = new Choice();
        chotel.setBounds(250,100,200,20);
        add(chotel);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField();
        tfdays.setBounds(250,190,200,25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);



        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,310,200,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,20);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,340,200,20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,340,200,20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,370,200,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,370,200,20);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,410,200,20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(250,410,200,20);
        add(labeltotal);

        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(200,460,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(340, 460,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 490,120,25);
        back.addActionListener(this);
        add(back);

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480,70,600,350);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperson"));
                    int food = Integer.parseInt(rs.getString("food_included"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labeltotal.setText("Rs "+total);
                    }else{
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("sonu123");
    }
}
