package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        String s = "\n" +
                "Four ways hotels can use technology and social media to stand apart from the rest and then turn their guests into loyal customers and advocates.\n" +
                "\n" +
                "This is a guest post by Steve Conway\n" +
                "\n" +
                "The hotel industry is a competitive space. There are an endless amount of options when it comes to booking a place to stay for the night. The strong competition puts hotels at risk of not filling their room occupancy. That’s why it’s so important to get ahead of the game and put measures in place that are going to ensure guests find you.\n" +
                "\n" +
                "The challenge for hotels is to stand apart from the rest and attract guests on a regular basis. It’s also important those guests turn into loyal customers and advocates, who go out and tell others about how great your enterprise is. Learn how to make your hotel stand out and boost visibility among guests:\n" +
                "\n" +
                " \n" +
                "\n" +
                "Guest Experience through Technology\n" +
                "\n" +
                "Technology is a great way to run your operations and engage with customers. It helps with hotel task management, and keeping open and clear communication with guests. You’re creating a lasting guest experience, instead of a check-in and checkout type of model. The hotels must be functioning at a level that allows them to easily and efficiently fulfill the guest’s request. It’s about using technology, like ALICE's hospitality operations platform, to break down the procedures and speed up the process so it’s done right the first time.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Website\n" +
                "\n" +
                "Another way for guests to find you is through search on the Internet. This is best done using a full service marketing agency, like Clickintelligence.com who are experts in SEO, Link Building, PR, outreach and PPC. Their goal is to help you grow your business because your successes are their successes. They tailor their internet marketing services so that each client gets a bespoke strategy that sets them apart within their industry. Visibility is a key component and that’s exactly what you can expect when working with them. \n" +
                "\n" +
                " \n" +
                "\n" +
                "Online Reviews\n" +
                "\n" +
                "Use reviews to your advantage. Ask your guests to go online and post them to your website and other relevant travel websites. Make sure you highlight and publicize the positive reviews and respond to the negative ones so customers can see you care. Many guests go online and read reviews before booking a hotel. They want to know what other customers like them think of the property and what kind of experience they had. This is yet another reason why it’s so important to impress your guest’s onsite at the property. They’ll be talking about you once they leave and you want it to be positive.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Social Media\n" +
                "\n" +
                "Social media has the ability to make a huge impact on your visibility and attracting new customers. Open up social media accounts on platforms that make sense for your business. Post engaging content consistently and use it as a way to connect with potential guests and answer customer service questions. Encourage your followers to share pictures of themselves at your hotel having fun and let them know you’ll feature the photos.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Conclusion\n" +
                "\n" +
                "Put your hotel out there and start winning over customers. Once you attract your guests, it’s up to you to provide an amazing time and keep them coming back for more. These are four ways hotels can boost visibility among guests. ";

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(150,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l1);

        TextArea area = new TextArea(s, 10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }


}
