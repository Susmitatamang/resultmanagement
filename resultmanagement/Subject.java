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
public class Subject implements ActionListener {
   JFrame frame=new JFrame("Subject");
    Container con=frame.getContentPane();
    JLabel Head,LSub_Code,LSubject;
    JTextField tSub_code,tSubject;
    JButton Submit,Back,update;
    Subject(){
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
        Head=new JLabel("Subject");
        Head.setFont(f1);
        con.add(Head);
        Head.setBounds(150,5,190,34);

        LSub_Code=new JLabel("Sub_Code");
        LSub_Code.setFont(f);
        con.add(LSub_Code);
        LSub_Code.setBounds(50,50,100,32);

        tSub_code=new JTextField();
        tSub_code.setFont(f);
        con.add(tSub_code);
        tSub_code.setBounds(160,50,220,32);




        LSubject=new JLabel("Subject");
        LSubject.setFont(f);
        con.add(LSubject);
        LSubject.setBounds(50,130,100,32);

        tSubject=new JTextField();
        tSubject.setFont(f);
        con.add(tSubject);
        tSubject.setBounds(160,130,220,32);

        Back=new JButton("back");
        Back.setFont(f);
        con.add(Back);
        Back.setBounds(0,0,60,32);
        Back.addActionListener(this);
        Back.setBackground(Color.red);


        Submit=new JButton("Submit");
        Submit.setFont(f);
        con.add(Submit);
        Submit.setBounds(130,210,100,32);
        Submit.addActionListener(this);
        Submit.setBackground(Color.green);

        update=new JButton("Update");
        update.setFont(f);
        con.add(update);
        update.setBounds(230,210,100,32);
        update.addActionListener(this);
        update.setBackground(Color.green);
        update.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if(ch=="<-"){
            frame.dispose();
            new MenuBar();
        }
        else if(ch=="Submit"){
            String Sub_code=tSub_code.getText();
            String subject=tSubject.getText();
            Database db=new Database();
            db.insertintoSubject(Sub_code,subject);
        }
        else if(ch=="Update"){
            String Sub_code=tSub_code.getText();
            String subject=tSubject.getText();
            Database db=new Database();
            tSub_code.setVisible(false);

            db.updateSubject(Sub_code,subject);
            frame.dispose();
            new SubjectShow();
        }
    }
}
 

