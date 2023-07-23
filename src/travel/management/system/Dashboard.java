package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackages,
            viewPackages, viewHotels,destination,bookHotels,viewBookedHotels,payment,calculator,notepad, about,delPersonalDetails;
    Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        delPersonalDetails = new JButton("Delete Personal Details");
        delPersonalDetails.setBounds(0,150,300,50);
        delPersonalDetails.setForeground(Color.WHITE);
        delPersonalDetails.setBackground(new Color(0,0,102));
        delPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        delPersonalDetails.setMargin(new Insets(0,0,0,40));
        delPersonalDetails.addActionListener(this);
        p2.add(delPersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,100));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(0,250,300,50);
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setBackground(new Color(0,0,102));
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookPackages.setMargin(new Insets(0,0,0,110));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Packages");
        viewPackages.setBounds(0,300,300,50);
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setBackground(new Color(0,0,102));
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPackages.setMargin(new Insets(0,0,0,110));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,130));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookHotels.setMargin(new Insets(0,0,0,130));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotels = new JButton("View Booked Hotels");
        viewBookedHotels.setBounds(0,450,300,50);
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setBackground(new Color(0,0,102));
        viewBookedHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewBookedHotels.setMargin(new Insets(0,0,0,60));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        destination = new JButton("Destinations");
        destination.setBounds(0,500,300,50);
        destination.setForeground(Color.WHITE);
        destination.setBackground(new Color(0,0,102));
        destination.setFont(new Font("Tahoma", Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,125));
        destination.addActionListener(this);
        p2.add(destination);

        payment = new JButton("Payments");
        payment.setBounds(0,550,300,50);
        payment.setForeground(Color.WHITE);
        payment.setBackground(new Color(0,0,102));
        payment.setFont(new Font("Tahoma", Font.PLAIN,20));
        payment.setMargin(new Insets(0,0,0,155));
        payment.addActionListener(this);
        p2.add(payment);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setForeground(Color.WHITE);
        calculator.setBackground(new Color(0,0,102));
        calculator.setFont(new Font("Tahoma", Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,140));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setForeground(Color.WHITE);
        notepad.setBackground(new Color(0,0,102));
        notepad.setFont(new Font("Tahoma", Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,150));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setForeground(Color.WHITE);
        about.setBackground(new Color(0,0,102));
        about.setFont(new Font("Tahoma", Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,170));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("DJ Travel and Tourist Management System");
        text.setBounds(400,70,1200,70);
        text.setFont(new Font("Raleway", Font.PLAIN,55));
        text.setForeground(Color.WHITE);
        image.add(text);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkPackages){
            new CheckPackages();
        }else if(ae.getSource() == bookPackages){
            new BookPackages(username);
        }else if(ae.getSource() == viewPackages){
            new ViewPackage(username);
        }else if(ae.getSource() == viewHotels){
            new CheckHotels();
        }else if(ae.getSource() == destination){
            new Destinations();
        }else if(ae.getSource() == bookHotels){
            new BookHotel(username);
        }else if(ae.getSource() == viewBookedHotels){
            new ViewBookedHotel(username);
        }else if(ae.getSource() == payment){
            new Payment();
        }else if(ae.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == about){
            new About();
        }else if(ae.getSource() == delPersonalDetails){
            new DeleteDetails(username);
        }

    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
