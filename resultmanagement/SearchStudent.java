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
public class SearchStudent implements ActionListener {
  JFrame frame= new JFrame("Result");
    Container con=frame.getContentPane();
    JLabel Lrollno,Head;
    JTextField Rollno;
    JButton Submit,back;
    static JTable ta;
    String column[] = {"Rool no", "Result", "Subject", "Grade"};
  public static   int s_ID=0;
    public static  int rollno=0;
    SearchStudent() {
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
        frame.setBounds(150, 150, 500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Serif", Font.BOLD, 16);

        Font f1 = new Font("Serif", Font.BOLD, 17);
        Head = new JLabel("Search Student!!");
        Head.setFont(f1);
        con.add(Head);
        Head.setBounds(150, 5, 190, 34);

        Lrollno = new JLabel("Roll no.");
        Lrollno.setFont(f);
        con.add(Lrollno);
        Lrollno.setBounds(50, 50, 100, 32);

        Rollno = new JTextField();
        Rollno.setFont(f);
        con.add(Rollno);
        Rollno.setBounds(150, 50, 200, 32);

        Submit = new JButton("Submit");
        Submit.setFont(f);
        con.add(Submit);
        Submit.setBounds(180, 180, 100, 32);
        Submit.setBackground(Color.green);
        Submit.addActionListener(this);

        back = new JButton("back");
        back.setFont(f);
        con.add(back);
        back.setBounds(0, 0, 70, 32);
        back.setBackground(Color.red);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        String ch = e1.getActionCommand();
        if (ch == "<-") {
            frame.dispose();
            new MenuBar();
        } else if (ch == "Submit") {
            rollno = Integer.parseInt(Rollno.getText());
            Database db1 = new Database();
            String sql2 = "SELECT S_ID FROM student WHERE Roll_No='" + rollno + "'";

            try {
                db1.rs = db1.st.executeQuery(sql2);
                db1.rs.next();
                s_ID = db1.rs.getInt("S_ID");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (s_ID == 0) {
                JOptionPane.showMessageDialog(null, "Sorry The Roll no. You enter is not exits in database.");
            } else {
                    frame.dispose();
                    new ThirdFrame();
            }
        }
    }  
}
