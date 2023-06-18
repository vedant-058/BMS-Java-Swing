import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class signin2 extends JFrame implements ActionListener {
    JTextField pannum,aadharnum;
    JButton next;
    JComboBox rbox,cbox,Income,education,occupation;
    JRadioButton yes,no,syes,sno;
    String formno;
    signin2(String formno){

        setLayout(null);
        this.formno=formno;

        JLabel additionaldetails=new JLabel("Page 2: Additional Details ");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel religion=new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] valreligion={"Select","Hindu","Other"};
        rbox=new JComboBox(valreligion);
        rbox.setFont(new Font("Raleway",Font.BOLD,14));
        rbox.setBackground(Color.white);
        rbox.setBounds(300,140,400,30);
        add(rbox);

        JLabel category=new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        String[] valcategory={"Select","General","OBC","Other"};
        cbox=new JComboBox(valcategory);
        cbox.setFont(new Font("Raleway",Font.BOLD,14));
        cbox.setBackground(Color.white);
        cbox.setBounds(300,190,400,30);
        add(cbox);

        JLabel income=new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        String[] valincome={"Select","0 - 2,50,000","2,50,000 - 7,50,000","7,50,000 - 15,00,000",">15,00,000"};
        Income=new JComboBox(valincome);
        Income.setFont(new Font("Raleway",Font.BOLD,14));
        Income.setBackground(Color.white);
        Income.setBounds(300,240,400,30);
        add(Income);

        JLabel edu=new JLabel("Education: ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
        String[] valedu={"Select","SSC","HSC","UG","PG"};
        education=new JComboBox(valedu);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        education.setBounds(300,290,400,30);
        education.setBackground(Color.white);
        add(education);


        JLabel occ=new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,340,200,30);
        add(occ);
        String[] valocc={"Select","Bussiness","Public Sector","Private Sector"};
        occupation=new JComboBox(valocc);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBounds(300,340,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pan=new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,390,200,30);
        add(pan);
        pannum=new JTextField();
        pannum.setFont(new Font("Raleway",Font.BOLD,14));
        pannum.setBounds(300,390,400,30);
        pannum.setBackground(Color.white);
        add(pannum);

        JLabel aadhar=new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);
        aadharnum=new JTextField();
        aadharnum.setFont(new Font("Raleway",Font.BOLD,14));
        aadharnum.setBounds(300,440,400,30);
        add(aadharnum);

        JLabel Senior=new JLabel("Senior Citizen: ");
        Senior.setFont(new Font("Raleway",Font.BOLD,20));
        Senior.setBounds(100,490,200,30);
        add(Senior);
        yes=new JRadioButton("Yes");
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        yes.setBounds(300,490,60,30);
        add(yes);
        no=new JRadioButton("No");
        no.setFont(new Font("Raleway",Font.BOLD,14));
        no.setBounds(440,490,60,30);
        add(no);
        ButtonGroup sen=new ButtonGroup();
        sen.add(yes);
        sen.add(no);

        JLabel exist=new JLabel("Existing Account: ");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100,540,200,30);
        add(exist);
        syes=new JRadioButton("Yes");
        syes.setFont(new Font("Raleway",Font.BOLD,14));
        syes.setBounds(300,540,60,30);
        add(syes);
        sno=new JRadioButton("No");
        sno.setFont(new Font("Raleway",Font.BOLD,14));
        sno.setBounds(440,540,60,30);
        add(sno);
        ButtonGroup exe=new ButtonGroup();
        exe.add(syes);
        exe.add(sno);

        next=new JButton("Next");
        next.setBackground(Color.pink);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(460,590, 80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.lightGray);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
//        JComboBox rbox,cbox,Income,education,occupation;
//        JRadioButton yes,no,syes,sno;
        String religion=(String)rbox.getSelectedItem();
        String category=(String)cbox.getSelectedItem();
        String income=(String)Income.getSelectedItem();
        String edu=(String)education.getSelectedItem();
        String occ=(String)occupation.getSelectedItem();
        String pnum=pannum.getText();
        String anum=aadharnum.getText();
        String seniorciti=null;
        if(yes.isSelected()){
            seniorciti="YES";
        } else if (no.isSelected()) {
            seniorciti="NO";
        }
        String exeist=null;
        if (syes.isSelected()){
            exeist="YES";
        } else if (sno.isSelected()) {
            exeist="NO";
        }

        try {
            connection c =new connection();
            String query= "insert into signuptwo values('"+formno+"',  '"+religion+"',  '"+category+
                    "',  '"+income+"',  '"+edu+
                    "',  '"+occ+"',  '"+pnum+"',  '"+anum+"',  '"
                    +seniorciti+"',  '"+exeist+"');";
            c.s.executeUpdate(query);


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signin2("");
    }
}

