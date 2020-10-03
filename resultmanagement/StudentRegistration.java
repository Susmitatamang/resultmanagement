/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author pema
 */
public class StudentRegistration implements ActionListener{
 JFrame frame=new JFrame("Student Registration");
    Container con=frame.getContentPane();
    JLabel head,Name, RollNo, Class,Section, Gender,Dob,lAddress;
    JTextField tname,tClass,taddress;
    JComboBox CRollNo,CSection,CDay,CMonth,CYear;
    ButtonGroup gender=new ButtonGroup();
    JRadioButton r1,r2;
    JButton Submit,Back,Update;

    StudentRegistration(){

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        frame.setBounds(150,150,800,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f=new Font("Serif",Font.BOLD,16);

        Font f1=new Font("Serif",Font.BOLD,17);
        head=new JLabel("Student Registration");
        head.setFont(f1);
        con.add(head);
        head.setBounds(200,10,190,34);



        Name=new JLabel("Name");
        Name.setFont(f);
        con.add(Name);
        Name.setBounds(70,50,100,32);

        tname=new JTextField();
        tname.setFont(f);
        con.add(tname);
        tname.setBounds(210,50,250,32);





        RollNo=new JLabel("Roll No.");
        RollNo.setFont(f);
        con.add(RollNo);
        RollNo.setBounds(70,100,100,32);

        String[] rollno=new String[100];
        for(int i=0;i<100;i++){
            String hello=Integer.toString(i+1);
            rollno[i]=hello;
        }
        CRollNo=new JComboBox(rollno);
        CRollNo.setFont(f);
        con.add(CRollNo);
        CRollNo.setBounds(210,100,50,32);




        Class=new JLabel("Class");
        Class.setFont(f);
        con.add(Class);
        Class.setBounds(70,150,100,32);

        tClass=new JTextField();
        tClass.setFont(f);
        con.add(tClass);
        tClass.setBounds(210,150,250,32);




        Section=new JLabel("Section");
        Section.setFont(f);
        con.add(Section);
        Section.setBounds(70,200,100,32);

        String[] sec={"A","B","C","D","F"};
        CSection=new JComboBox(sec);
        CSection.setFont(f);
        con.add(CSection);
        CSection.setBounds(210,200,50,32);




        Gender=new JLabel("Gender");
        Gender.setFont(f);
        con.add(Gender);
        Gender.setBounds(70,250,100,32);

        r1=new JRadioButton("Male");
        r1.setBounds(210,250,70,32);
        con.add(r1);
        r1.setFont(f);

        r2=new JRadioButton("Female");
        r2.setBounds(280,250,90,32);
        con.add(r2);
        r2.setFont(f);
        gender.add(r1);
        gender.add(r2);




        Dob=new JLabel("D.O.B.");
        Dob.setFont(f);
        con.add(Dob);
        Dob.setBounds(70,300,100,32);

        String[] daylist=new String[32];
        for(int i=0;i<32;i++){
            String hello=Integer.toString(i+1);
            daylist[i]=hello;
        }
        CDay=new JComboBox<>(daylist);
        CDay.setFont(f);
        con.add(CDay);
        CDay.setBounds(210,300,50,32);

        String[] Monthlist={"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        CMonth=new JComboBox(Monthlist);
        CMonth.setFont(f);
        con.add(CMonth);
        CMonth.setBounds(270,300,60,32);

        String Yearlist[] = new String[100];
        for (int i = 0; i < Yearlist.length; i++) {
            String another_variable = Integer.toString(i + 1919);
            Yearlist[i] = another_variable;
        }
        CYear=new JComboBox(Yearlist);
        CYear.setFont(f);
        con.add(CYear);
        CYear.setBounds(360,300,90,32);




        lAddress=new JLabel("Address");
        lAddress.setFont(f);
        con.add(lAddress);
        lAddress.setBounds(70,350,100,32);

        taddress=new JTextField();
        taddress.setFont(f);
        con.add(taddress);
        taddress.setBounds(210,350,250,32);



        Submit=new JButton("Submit");
        Submit.setFont(f);
        con.add(Submit);
        Submit.setBounds(170,405,100,32);
        Submit.addActionListener(this);
        Submit.setBackground(Color.green);



        Update=new JButton("Update");
        Update.setFont(f);
        con.add(Update);
        Update.setBounds(170,405,100,32);
        Update.addActionListener(this);
        Update.setBackground(Color.green);

        Back=new JButton("back");
        Back.setFont(f);
        con.add(Back);
        Back.setBounds(0,0,45,32);
        Back.addActionListener(this);
        Back.setBackground(Color.red);
    }
    public static void main(String[] arg){
        new StudentRegistration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if(ch=="<-"){
            frame.dispose();
            new MenuBar();
        }
        else if(ch=="Submit"){
            String name=tname.getText();
            int rollno=Integer.parseInt (CRollNo.getSelectedItem().toString());
            String classs=tClass.getText();
            String section=CSection.getSelectedItem().toString();
            String gend = "Male";
            if (r2.isSelected()) {
                gend = "Female";
            }
            String day=CDay.getSelectedItem().toString();
            String month=(String)CMonth.getSelectedItem();
            String year=(String) CYear.getSelectedItem();
            String dob=(day+"/"+month+"/"+year).toString();
            String address=taddress.getText();

        try {
            Database db=new Database();
            db.insertintoStudent(name,rollno,classs,section,gend,dob,address.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        else if(ch=="Update"){
            String name=tname.getText();
            int rollno=Integer.parseInt (CRollNo.getSelectedItem().toString());
            String classs=tClass.getText();
            String section=CSection.getSelectedItem().toString();
            String gend = "Male";
            if (r2.isSelected()) {
                gend = "Female";
            }
            String day=CDay.getSelectedItem().toString();
            String month=(String)CMonth.getSelectedItem();
            String year=(String) CYear.getSelectedItem();
            String dob=(day+"/"+month+"/"+year).toString();
            String address=taddress.getText();
            Database db=new Database();
            StudentShow ss = new StudentShow();
            ss.frame.dispose();
            int a = ss.S_Id;
            db.updateStudent(a,name,rollno,classs,section,gend,dob,address);
            frame.dispose();
            new StudentShow();

        }
}
}
