/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultmanagement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author pema
 */
public class ThirdFrame implements ActionListener {
JFrame frame = new JFrame("Result");
    Container con = frame.getContentPane();
    JFrame frame1;
    JButton back;
    static JTable ta;

    String column[] = {"Rool no", "Result", "Subject", "Grade"};
    ThirdFrame(){
        frame.setVisible(true);
        frame.setBounds(150, 150, 500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Serif", Font.BOLD, 16);


        back = new JButton("<-");
        back.setFont(f);
        con.add(back);
        back.setBounds(0, 0, 70, 32);
        back.setBackground(Color.red);
        back.addActionListener(this);

        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        ta = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        ta.setModel(model);
        ta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        ta.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        model.setColumnIdentifiers(column);
        frame1.setBounds(150, 210, 600, 400);
        frame1.add(scroll);
        frame1.setVisible(true);

        try {
            Database db = new Database();
            SearchStudent ss=new SearchStudent();
            ss.frame.dispose();
            int result = 0;
            int roll=ss.rollno;
            int s_ID=ss.s_ID;
            String subject="";
            String subs_code="";
            String gradee="";
            String sql = "Select Result_ID, Subject_Code from result where Student_Id='" + s_ID + "'";
            db.rs = db.st.executeQuery(sql);
            try {
            while (db.rs.next()) {
                    result = db.rs.getInt("Result_ID");
                    subs_code=db.rs.getString("Subject_Code");
                    subject=Retrive_subject(subs_code);

                }
                if (result >= 80) {
                    gradee = "A";
                } else if (result >= 60 || result < 80) {
                    gradee = "B";
                } else if (result < 60 || result >= 40) {
                    gradee = "C";
                } else if (result < 40) {
                    gradee = "D";
                }
                model.addRow(new Object[]{roll,result, subject, gradee});
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String Retrive_subject(String subcode){
        Database db2=new Database();
        String sql5="SELECT Subject FROM subject WHERE Sub_code='"+subcode+"'";
        String subject="";
        try {
            db2.rs = db2.st.executeQuery(sql5);
            db2.rs.next();
            subject=db2.rs.getString("Subject");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subject;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if (ch == "<-") {
            frame.dispose();
            frame1.dispose();
            new SearchStudent();
        }
    }

}
