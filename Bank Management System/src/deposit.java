import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton dep,back;
    String pinnumber;
    deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon("E:\\Java Projects\\Bank Management System\\src\\icons\\atm.jpg");
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter Amount: ");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        dep =new JButton("Deposit");
        dep.setBounds(355,485,150,30);
        dep.addActionListener(this);
        image.add(dep);

        back =new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==dep){
            String input=amount.getText();
            Date date=new Date();
            if(input.equals(""))
                JOptionPane.showMessageDialog(null,"Enter Amount");
            else{
                try{
                    connection c=new connection();
                    String query="insert into bank values('"+pinnumber+"',  '"+date+"',  'Deposit', '"+input+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs: "+input+" Deposited Successfully");
                    setVisible(false);
                    new transaction("").setVisible(true);
                }
                catch (Exception a){
                    System.out.println(a);
                }

            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new deposit("");
    }
}
