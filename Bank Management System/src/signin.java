import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class signin extends JFrame{
    signin(){
        setLayout(null);
        Random ran=new Random();
        long x=Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("Form Number: "+x);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        formno.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        add(formno);

        JLabel personaldetails=new JLabel("Page 1: Personal Details ");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        JTextField nametextfield=new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname=new JLabel("Father Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        JTextField fathertextfield=new JTextField();
        fathertextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fathertextfield.setBounds(300,190,400,30);
        add(fathertextfield);

        JLabel dob=new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        JTextField dobtextfield=new JTextField();
        dobtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        dobtextfield.setBounds(300,240,400,30);
        add(dobtextfield);


        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        JRadioButton male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.lightGray);
        add(male);
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.lightGray);
        add(female);
        ButtonGroup gendergroup =new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        JTextField emailtextfield=new JTextField();
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);

        JLabel maritial=new JLabel("Maritial Status: ");
        maritial.setFont(new Font("Raleway",Font.BOLD,20));
        maritial.setBounds(100,390,200,30);
        add(maritial);
        JRadioButton married=new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.lightGray);
        add(married);
        JRadioButton unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.lightGray);
        add(unmarried);
        ButtonGroup marriedgroup =new ButtonGroup();
        gendergroup.add(married);
        gendergroup.add(unmarried);

        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        JTextField addresstextfield=new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        JTextField citytextfield=new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        JTextField statetextfield=new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pincode=new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        JTextField pincodetextfield=new JTextField();
        pincodetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetextfield.setBounds(300,590,400,30);
        add(pincodetextfield);

        JButton next=new JButton("Next");
        next.setBackground(Color.pink);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,620, 80,30);
        add(next);

        getContentPane().setBackground(Color.lightGray);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new signin();
    }
}
