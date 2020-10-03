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
import java.sql.SQLException;
/**
 *
 * @author pema
 */
public class ResultEntry implements ActionListener {
   JFrame frame= new JFrame("Result");
    Container con=frame.getContentPane();
    JLabel Lrollno,LRsult,Head;
    JTextField Rollno,rrsult;
    JButton Submit,Back,Update;
    ResultEntry(){
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
        frame.setVisible(true);
        frame.setBounds(150,150,500,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f=new Font("Serif", Font.BOLD,16);

        Font f1=new Font("Serif",Font.BOLD,17);
        Head=new JLabel("Enter result!!");
        Head.setFont(f1);
        con.add(Head);
        Head.setBounds(150,5,190,34);

        Lrollno=new JLabel("Roolno.");
        Lrollno.setFont(f);
        con.add(Lrollno);
        Lrollno.setBounds(50,50,100,32);

        Rollno=new JTextField();
        Rollno.setFont(f);
        con.add(Rollno);
        Rollno.setBounds(160,50,220,32);




        LRsult=new JLabel("Marks");
        LRsult.setFont(f);
        con.add(LRsult);
        LRsult.setBounds(50,130,100,32);

        rrsult=new JTextField();
        rrsult.setFont(f);
        con.add(rrsult);
        rrsult.setBounds(160,130,220,32);

        Back=new JButton("back");
        Back.setFont(f);
        con.add(Back);
        Back.setBounds(0,0,45,32);
        Back.addActionListener(this);
        Back.setBackground(Color.red);


        Submit=new JButton("Submit");
        Submit.setFont(f);
        con.add(Submit);
        Submit.setBounds(130,210,100,32);
        Submit.addActionListener(this);
        Submit.setBackground(Color.green);

        Update=new JButton("Update");
        Update.setFont(f);
        con.add(Update);
        Update.setBounds(230,210,100,32);
        Update.addActionListener(this);
        Update.setBackground(Color.green);
        Update.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String ch=e.getActionCommand();
    if(ch=="<-"){
        frame.dispose();
        new ResultAdd();
    }
    else if(ch=="Submit"){
        int result= Integer.parseInt(rrsult.getText()) ;
        int rool=Integer.parseInt(Rollno.getText());
        ResultAdd ar=new ResultAdd();
        ar.frame.dispose();
        String name=ar.subname;
        Database db=new Database();
        String subcode="";

        String sql="SELECT Sub_code FROM subject WHERE Subject='"+name+"'";

        try {
            db.rs = db.st.executeQuery(sql);

            db.rs.next();
            subcode=(db.rs.getString("Sub_code"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int s_ID = 0;
        String sql2="SELECT S_ID FROM student WHERE Roll_No='"+rool+"'";
        try{
            db.rs = db.st.executeQuery(sql2);
            db.rs.next();
            s_ID=db.rs.getInt("S_ID");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.insertintoResult(result,s_ID,subcode);
    }
    else if(ch=="Update"){
        Database db=new Database();
        int result= Integer.parseInt(rrsult.getText()) ;
        int rool=Integer.parseInt(Rollno.getText());
        String sql3="SELECT S_ID FROM student WHERE Roll_No='"+rool+"'";
        int Student_ID=0;
        ResultShow rs=new ResultShow();
        String sub=rs.sub;
        try{
            db.rs = db.st.executeQuery(sql3);
            db.rs.next();
            Student_ID=db.rs.getInt("S_ID");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.UpdateREsult(result,Student_ID,sub);
        new ResultShow();
        System.out.println(sub);
    }
    }
}
 

