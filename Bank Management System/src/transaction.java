import javax.swing.*;
import java.awt.*;

public class transaction extends JFrame {
        transaction(){
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

//            JButton

            setSize(900,900);
            setLocation(300,0);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }

    public static void main(String[] args) {
        new transaction();
    }
}
