import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class pinchange extends JFrame implements ActionListener {
    JLabel image;
    JPasswordField pinentry,repinentry;
    JButton change,back;
    String pin;
    pinchange(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Change Your PIN: ");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pintext=new JLabel("New PIN: ");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        pinentry=new JPasswordField();
        pinentry.setFont(new Font("Raleway",Font.BOLD,25));
        pinentry.setBounds(330,320,180,25);
        image.add(pinentry);

        JLabel repintext=new JLabel("Confirm New PIN: ");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);

        repinentry=new JPasswordField();
        repinentry.setFont(new Font("Raleway",Font.BOLD,25));
        repinentry.setBounds(330,360,180,25);
        image.add(repinentry);

        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change) {
            try {
                String npin = pinentry.getText();
                String ppin = repinentry.getText();
                if (!npin.equals(ppin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
                    return;
                }
                if(npin.equals("") || ppin.equals("")){
                    JOptionPane.showMessageDialog(null, "Fields Cannot be empty");
                    return;
                }
                connection con=new connection();
                String q1="update bank set pin = '"+ppin+"' where pin='"+pin+"'";
                String q2="update login set pin = '"+ppin+"' where pin='"+pin+"'";
                String q3="update signupthree set pin = '"+ppin+"' where pin='"+pin+"'";
                con.s.executeUpdate(q1);
                con.s.executeUpdate(q2);
                con.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Change Successfull");
                setVisible(false);
                new transaction(ppin).setVisible(true);
            } catch (Exception pe) {
                System.out.println(pe);
            }
        }
        else{
            setVisible(false);
            new transaction(pin).setVisible(true);
        }
    }
}
