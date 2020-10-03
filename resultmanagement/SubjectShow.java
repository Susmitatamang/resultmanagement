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
import java.util.ArrayList;
/**
 *
 * @author pema
 */
public class SubjectShow implements ActionListener {
JFrame frame = new JFrame("Show Subject");
    Container con = frame.getContentPane();
    JFrame frame1;
    JButton Edit, Delete, back;
    static JTable ta;
    public static String sub;
    String column[] = {"Subject Code", "Subject"};
    SubjectShow() {
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

        back = new JButton("<-");
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


        try{
            Database db=new Database();
            String sql="select * from subject";
            db.rs = db.st.executeQuery(sql);
            String s_code="";
            String subject="";

            while(db.rs.next()){
                s_code = db.rs.getString("Sub_code");
                subject=db. rs.getString("Subject");
                model.addRow(new Object[]{s_code,subject});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if(ch=="<-"){
            frame1.dispose();
            frame.dispose();;
            new MenuBar();
        }
        else if(ch=="Delete"){
            int i=ta.getSelectedRow();
            String ab=ta.getValueAt(i,0).toString();
            Database db=new Database();
            {

                db.deleteSubject(ab);
                JOptionPane.showMessageDialog(null,"Deleted Successfully!");
            }
            ta.getSelectedColumn();
        }
        else if(ch=="Edit"){
            Subject s=new Subject();
            int i=ta.getSelectedRow();
            s.tSub_code.setText(String.valueOf(ta.getValueAt(i,0).toString()));
            s.tSubject.setText(String.valueOf(ta.getValueAt(i,1).toString()));
            s.Submit.setVisible(false);
            s.tSub_code.setEditable(false);
            frame.dispose();
            frame1.dispose();
        }

    }
}
