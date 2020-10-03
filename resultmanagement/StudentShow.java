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
public class StudentShow implements ActionListener {
    JFrame frame=new JFrame("Show Student");
    Container con=frame.getContentPane();
    JFrame frame1;
    JButton Edit,Delete,back;
    static JTable ta;
    public static int S_Id;
    String column[]={"Name","Roll No.","Class","Section","Gender","D.O.B","Address"};
    StudentShow(){
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
        frame.setBounds(150,150,700,550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Serif", Font.BOLD, 16);


        Edit=new JButton("Edit");
        Edit.setFont(f);
        con.add(Edit);
        Edit.setBounds(10,450,100,32);
        Edit.addActionListener(this);

        Delete=new JButton("Delete");
        Delete.setFont(f);
        con.add(Delete);
        Delete.setBounds(150,450,100,32);
        Delete.addActionListener(this);

        back=new JButton("<-");
        back.setFont(f);
        con.add(back);
        back.setBounds(0,0,80,32);
        back.setBackground(Color.red);
        back.addActionListener(this);


        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        ta=new JTable();
        DefaultTableModel model=new DefaultTableModel();
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
        frame1.setBounds(150,210,600,400);
//        frame1.setSize(600,400);


        try{
            Database db=new Database();
            String sql="select * from student";
            db.rs = db.st.executeQuery(sql);
            String name="";
            int rollno;
            String classs="";
            String section="";
            String gender="";
            String dob="";
            String address="";
            while(db.rs.next()){
                name = db.rs.getString("Name");
                rollno=db. rs.getInt("Roll_No");
                classs =db. rs.getString("Class");
                section = db.rs.getString("Section");
                gender = db.rs.getString("Gender");
                dob=db.rs.getString("DOB");
                address=db.rs.getString("Address");
                model.addRow(new Object[]{name,rollno,classs,section,gender,dob,address});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ch=e.getActionCommand();
        if(ch=="<-")
        {
            frame1.dispose();
            frame.dispose();
            new MenuBar();
        }
        else if(ch=="Delete"){
            int i=ta.getSelectedRow();
            String ab=ta.getValueAt(i,0).toString();
            Database db=new Database();
            String sql="select S_ID from student where Name='"+ab+"'";
            {
                try {
                    db.rs = db.st.executeQuery(sql);
                    db.rs.next();
                    S_Id=db.rs.getInt("S_ID");
                    db.deleteStudent(S_Id);
                    JOptionPane.showMessageDialog(null,"Deleted Successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            ta.getSelectedColumn();
        }
        else if(ch=="Edit"){
            StudentRegistration s_res=new StudentRegistration();
            int i=ta.getSelectedRow();
            s_res.tname.setText(String.valueOf(ta.getValueAt(i,0).toString()));
            String rollno=String.valueOf(ta.getValueAt(i,1).toString());
            s_res.CRollNo.setSelectedItem(rollno);
            s_res.tClass.setText(String.valueOf(ta.getValueAt(i,2).toString()));
            String a=String.valueOf(ta.getValueAt(i,3).toString());
            s_res.CSection.setSelectedItem(a);
            String gender=String.valueOf(ta.getValueAt(i,4).toString());

            if(gender=="Male"){
                s_res.r1.doClick();
            }
            else{
                s_res.r2.doClick();
            }
            s_res.taddress.setText( String.valueOf(ta.getValueAt(i,6).toString()));
            Database db=new Database();
            String name=String.valueOf(ta.getValueAt(i,0).toString());
            String sql="select S_ID from student where Name='"+name+"'";
            try {
                db.rs = db.st.executeQuery(sql);
                db.rs.next();
                S_Id=db.rs.getInt("S_ID");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            s_res.Update.setVisible(true);
            s_res.Submit.setVisible(false);
            frame.dispose();

        }
}

    void studentshow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

