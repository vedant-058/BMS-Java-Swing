import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login ,signin,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM");
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("E:\\Java Projects\\Bank Management System\\src\\icons\\logo.jpg");
        Image i2 = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card ID: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);

        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);

        login =new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.pink);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        signin =new JButton("SIGN IN");
        signin.setBounds(450,300,100,30);
        signin.setBackground(Color.pink);
        signin.setForeground(Color.BLACK);
        signin.addActionListener(this);
        add(signin);

        clear =new JButton("CLEAR");
        clear.setBounds(325,380,200,30);
        clear.setBackground(Color.pink);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.lightGray);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            connection c=new connection();
            String cn=cardTextField.getText();
            String pin=pinTextField.getText();
            String query = "select * from login where CardNum = '"+cn+"' and Pin = '"+pin+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction("").setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Data");
                }
            }
            catch (Exception ee){
                System.out.println(ee);
            }
        }
        else if(e.getSource()==signin){
            setVisible(false);
            new signin().setVisible(true);
        }
        else if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
