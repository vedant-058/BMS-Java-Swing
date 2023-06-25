import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balance,exit;
    String pinNum;
    transaction(String pinNum){
        this.pinNum=pinNum;
            setLayout(null);
            ImageIcon i1=new ImageIcon("E:\\Java Projects\\Bank Management System\\src\\icons\\atm.jpg");
            Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);

            JLabel text=new JLabel("Please select your Transaction");
            text.setBounds(210,300,700,35);
            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,16));
            image.add(text);

            deposit=new JButton("Deposit");
            deposit.setBounds(170,415,150,30);
            deposit.addActionListener(this);
            image.add(deposit);

            withdrawal=new JButton("Cash Withdrawal");
            withdrawal.setBounds(355,415,150,30);
            withdrawal.addActionListener(this);
            image.add(withdrawal);

            fastcash=new JButton("Fast Cash");
            fastcash.setBounds(170,450,150,30);
            fastcash.addActionListener(this);
            image.add(fastcash);

            ministatement=new JButton("Mini Statement");
            ministatement.setBounds(355,450,150,30);
            ministatement.addActionListener(this);
            image.add(ministatement);

            pinchange=new JButton("Pin Change");
            pinchange.setBounds(170,485,150,30);
            pinchange.addActionListener(this);
            image.add(pinchange);

            balance=new JButton("Balance Enquiry");
            balance.setBounds(355,485,150,30);
            balance.addActionListener(this);
            image.add(balance);

            exit=new JButton("Exit");
            exit.setBounds(355,520,150,30);
            exit.addActionListener(this);
            image.add(exit);


            setSize(900,900);
            setLocation(300,0);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setUndecorated(true);
            setVisible(true);
        }

    public static void main(String[] args) {
        new transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new deposit(pinNum).setVisible(true);
        }
        else if (e.getSource()==withdrawal) {
            setVisible(false);
            new withdrawal(pinNum).setVisible(true);
        }
        else if (e.getSource()==fastcash) {
            setVisible(false);
            new fastcash(pinNum).setVisible(true);
        }
    }
}
