import javax.swing.*;
import java.awt.*;

public class signup3 extends JFrame {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4;
    signup3(){
        setLayout(null);
        JLabel l1 =new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type =new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,22));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,200,20);
        add(r1);

        r2=new JRadioButton("Fixed Account");
        r2.setFont(new Font("Raleway",Font.BOLD,22));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,22));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4=new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,22));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup accounts=new ButtonGroup();
        accounts.add(r1);
        accounts.add(r2);
        accounts.add(r3);
        accounts.add(r4);

        JLabel card =new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number =new JLabel("XXXX-XXXX-XXXX-5767");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(100,300,300,20);
        add(number);

        JLabel carddetails =new JLabel("Your 16 Digit Card Number:");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(330,330,300,30);
        add(carddetails);

        JLabel pin =new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pindetails =new JLabel("Your 4 Digit Pin: ");
        pindetails.setFont(new Font("Raleway",Font.BOLD,22));
        pindetails.setBounds(100,400,200,30);
        add(pindetails);

        JLabel pinnumber =new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,370,300,30);
        add(pinnumber);

        JLabel services =new JLabel("Service Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new signup3();
    }
}
