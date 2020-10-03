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
import java.util.ArrayList;
/**
 *
 * @author pema
 */
public class ShowResult implements ActionListener {
JFrame frame = new JFrame("Add Result");
    Container con = frame.getContentPane();
    JLabel LSubject,head;
    JComboBox CSubjects;
    JButton Submit, back;
    public static String sub_name;
    ShowResult() {
        frame.setBounds(150, 150, 500, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        Font f = new Font("Serif", Font.BOLD, 16);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFont(f);


        head=new JLabel("Select Subject to Display the result");
        head.setFont(f);
        con.add(head);
        head.setBounds(100,0,300,32);

        LSubject = new JLabel("Subject");
        LSubject.setFont(f);
        con.add(LSubject);
        LSubject.setBounds(50, 50, 100, 32);

        CSubjects = new JComboBox(subs());
        CSubjects.setFont(f);
        con.add(CSubjects);
        CSubjects.setBounds(150, 50, 200, 32);

        Submit = new JButton("Submit");
        Submit.setFont(f);
        con.add(Submit);
        Submit.setBounds(180, 180, 100, 32);
        Submit.setBackground(Color.green);
        Submit.addActionListener(this);


        back = new JButton("<-");
        back.setFont(f);
        con.add(back);
        back.setBounds(0, 0, 70, 32);
        back.setBackground(Color.red);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if(ch=="<-"){
            frame.dispose();
            new MenuBar();
        }
        else if(ch=="Submit"){
            sub_name=CSubjects.getSelectedItem().toString();
            frame.dispose();
            new ResultShow();

        }
    }
    public String[] subs(){
        ArrayList<String> sub=new ArrayList<>();

        try{
            Database db=new Database();
            String sql="SELECT * FROM subject";
            db.rs = db.st.executeQuery(sql);
            while(db.rs.next()){
                sub.add(db.rs.getString("Subject"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] subject=new String[sub.size()];
        for (int i =0; i < sub.size(); i++)
            subject[i] = sub.get(i);
        return subject;
    }
}