import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String formno;
    signup3(String formno){
        this.formno=formno;
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
        r1.setBounds(100,180,250,20);
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
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetails =new JLabel("Your 16 Digit Card Number:");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,330,300,30);
        add(carddetails);

        JLabel pin =new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pindetails =new JLabel("Your 4 Digit Pin: ");
        pindetails.setFont(new Font("Raleway",Font.BOLD,22));
        pindetails.setBounds(100,400,300,30);
        add(pindetails);

        JLabel pinnumber =new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,370,300,30);
        add(pinnumber);

        JLabel services =new JLabel("Service Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350,500,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100,550,200,30);
        add(c3);
        c4=new JCheckBox("Emails & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setBounds(350,550,200,30);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100,600,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(350,600,200,30);
        add(c6);

        c=new JButton("Cancel");
        c.setBackground(Color.BLACK);
        c.setForeground(Color.white);
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBounds(700,200,100,30);
        c.addActionListener(this);
        add(c);

        s=new JButton("Submit");
        s.setBackground(Color.BLACK);
        s.setForeground(Color.white);
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBounds(700,250,100,30);
        s.addActionListener(this);
        add(s);

        setSize(820,720);
        setLocation(0,0);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acctype=null;
        if(e.getSource()==s){
            if(r1.isSelected()){
                acctype="Saving";
            } else if (r2.isSelected()) {
                acctype="FixedDeposit";
            }
            else if (r3.isSelected()) {
                acctype="Current";
            }
            else if (r4.isSelected()) {
                acctype="Reccuring";
            }
            Random ran=new Random();
            String cardnum=""+Math.abs((ran.nextLong()%90000000L+5085153200000000L));
            String pin=""+Math.abs((ran.nextLong()%9000L)+1000L);
            String Facility="";
            if(c1.isSelected()){
                Facility=Facility+" ATM card";
            } else if (c2.isSelected()) {
                Facility=Facility+" Internet Banking";
            }
            else if (c3.isSelected()) {
                Facility=Facility+" Mobile Banking";
            }
            else if (r4.isSelected()) {
                Facility=Facility+" EMAIL & SMS Alerts";
            }
            else if (c5.isSelected()) {
                Facility=Facility+" Cheque Book";
            }
            else if (c6.isSelected()) {
                Facility=Facility+" E Statement";
            }
            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is Mandatory");
                }
                else{
                    connection conn =new connection();
                    String query =" insert into signupthree values('"+formno+"','"+acctype+"','"+cardnum+"','"+pin+"','"+Facility+"')";
                    String query2 =" insert into login values('"+formno+"','"+cardnum+"','"+pin+"')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnum+"\n Pin: "+pin);
                }
            }catch (Exception x){
                System.out.println(x);
            }
        } else if (e.getSource()==c) {
            setVisible(false);

        }
    }
}
