package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackages extends JFrame implements ActionListener {
    Choice cpackages;
    JTextField tfpersons;
    JLabel labelusername, labelid,labelnumber,labelphone,labeltotal;
    JButton checkprice, bookpackage, back;
    String username;
    BookPackages(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
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


        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,200,20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        cpackages = new Choice();
        cpackages.add("Gold Package");
        cpackages.add("Silver Package");
        cpackages.add("Bronze Package");
        cpackages.setBounds(250,100,200,20);
        add(cpackages);




        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,25);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);

        tfpersons = new JTextField();
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);



        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,200,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,20);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,200,20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,200,20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,200,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,20);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,200,20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,200,20);
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
                tfpersons.setText(rs.getString("person"));
                labeltotal.setText(rs.getString("total"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(200,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(340, 380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 420,120,25);
        back.addActionListener(this);
        add(back);

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,350);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackages.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            }else if(pack.equals("Silver Package")){
                cost += 24000;
            }else{
                cost += 32000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText("Rs " + cost);

        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"', '"+cpackages.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");

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
        new BookPackages("sonu123");
    }
}
