import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class fastcash extends JFrame implements ActionListener {
    JButton a100,a500,a1000,a2500,a5000,a10000,back;
    String pinNum;
    fastcash(String pinNum){
        this.pinNum=pinNum;
        setLayout(null);
        ImageIcon i1=new ImageIcon("E:\\Java Projects\\Bank Management System\\src\\icons\\atm.jpg");
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        a100=new JButton("Rs 100/-");
        a100.setBounds(170,415,150,30);
        a100.addActionListener(this);
        image.add(a100);

        a500=new JButton("Rs 500/-");
        a500.setBounds(355,415,150,30);
        a500.addActionListener(this);
        image.add(a500);

        a1000=new JButton("Rs 1000/-");
        a1000.setBounds(170,450,150,30);
        a1000.addActionListener(this);
        image.add(a1000);

        a2500=new JButton("Rs 2500/-");
        a2500.setBounds(355,450,150,30);
        a2500.addActionListener(this);
        image.add(a2500);

        a5000=new JButton("Rs 5000/-");
        a5000.setBounds(170,485,150,30);
        a5000.addActionListener(this);
        image.add(a5000);

        a10000=new JButton("Rs 10000/-");
        a10000.setBounds(355,485,150,30);
        a10000.addActionListener(this);
        image.add(a10000);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new fastcash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new transaction(pinNum).setVisible(true);
        } else {
            String amount= ((JButton)e.getSource()).getText().substring(3);
            connection c=new connection();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin is ='"+pinNum+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                else {
                    Date date=new Date();
                    String query="insert into bank values('"+pinNum+"', '"+date+"', 'Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+ amount+" Debited Sucessfully");
                    setVisible(true);
                    new transaction(pinNum).setVisible(true);
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
}
