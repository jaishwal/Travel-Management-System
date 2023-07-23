package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar bar;
    Thread t;
    String username;
    @Override
    public void run(){
        try{
            for(int i = 1; i <= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;
        t = new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(200,140,600,40);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel username1 = new JLabel("Welcome "+username);
        username1.setBounds(20,310,400,40);
        username1.setForeground(Color.RED);
        username1.setFont(new Font("Raleway",Font.BOLD,16));
        add(username1);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
