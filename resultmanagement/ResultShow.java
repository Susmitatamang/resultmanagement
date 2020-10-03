/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultmanagement;
import org.w3c.dom.ls.LSOutput;

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
public class ResultShow implements ActionListener {
    JFrame frame = new JFrame("Result");
    Container con = frame.getContentPane();
    JFrame frame1;
    JButton Edit, Delete, back;
    static JTable ta;
    public static int S_Id;
    String column[] = {"Rool no", "Result", "Subject", "Grade"};
   public static  String subject;
    public static String sub;
    private String sub_name;
    ResultShow() {
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

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBounds(150, 150, 700, 550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Serif", Font.BOLD, 16);


        Edit = new JButton("Edit");
        Edit.setFont(f);
        con.add(Edit);
        Edit.setBounds(10, 450, 100, 32);
        Edit.addActionListener(this);

        Delete = new JButton("Delete");
        Delete.setFont(f);
        con.add(Delete);
        Delete.setBounds(150, 450, 100, 32);
        Delete.addActionListener(this);

        back = new JButton("back");
        back.setFont(f);
        con.add(back);
        back.setBounds(0, 0, 80, 32);
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
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setBounds(150, 210, 600, 400);
//        frame1.setSize(600,400);


        try {
            Database db = new Database();

            String sql = "select * from result where Subject_Code='" + subscode() + "'";
            db.rs = db.st.executeQuery(sql);
            int result = 0;
            int roll_no = 0;

            String gradee = "";
            while (db.rs.next()) {
                result = db.rs.getInt("Result_Id");
                int Studetn_ID = db.rs.getInt("Student_Id");
                String sql2 = "SELECT Roll_No FROM student WHERE S_ID='" + Studetn_ID + "'";
                try {
                    db.rs = db.st.executeQuery(sql2);
                    db.rs.next();
                    roll_no = db.rs.getInt("Roll_No");
                } catch (SQLException ex) {
                    ex.printStackTrace();
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


                model.addRow(new Object[]{roll_no, result, subject, gradee});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch = e.getActionCommand();
        if (ch == "<-") {
            frame1.dispose();
            frame.dispose();
            new ResultShow();
        } else if (ch == "Delete") {
            int i = ta.getSelectedRow();
            System.out.println(ta.getValueAt(i, 1).toString());
            int ab = Integer.parseInt(ta.getValueAt(i, 1).toString());
            Database db = new Database();
            db.delete_result(ab);
            ta.getSelectedColumn();
        } else if (ch == "Edit") {
            ResultEntry r_E = new ResultEntry();
            int i = ta.getSelectedRow();
            r_E.Rollno.setText(String.valueOf(ta.getValueAt(i, 0).toString()));
            r_E.rrsult.setText(String.valueOf(ta.getValueAt(i, 1).toString()));
            sub=String.valueOf(ta.getValueAt(i, 2).toString());
            r_E.Update.setVisible(true);
            r_E.Submit.setVisible(false);
            frame.dispose();
        }
    }

    public String subscode() {
            Database db1 = new Database();
            ResultShow sr = new ResultShow();
            sr.frame.dispose();
            subject = sr.sub_name;
            String subcode = "";
            String sql1 = "Select Sub_Code from subject where Subject='" + subject + "'";
            try {
                db1.rs = db1.st.executeQuery(sql1);
                db1.rs.next();
                subcode = db1.rs.getString("Sub_code");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return (subcode);
        }

    }

