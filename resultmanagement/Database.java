/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultmanagement;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author pema
 */
public class Database {
   public java.sql.Connection conn;
    public java.sql.ResultSet rs, rs1, rs2, rs3;
    public java.sql.Statement st;
    public static String[] subaaray;
    int i=0;
    Database() {
        try {
            String url = "jdbc:mysql://localhost:3306/assignment?zeroDateTimeBehavior=con"
                    + "vertToNull [root on Default schema]";
            String userName = "root";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, "");
            st = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            conn.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void insertintoStudent(String name, int Rollno, String Class, String section, String gender, String DOB, String address) {
        try {
            String sql = "insert into student( Name, Roll_No, Class, Section, Gender, DOB, Address) values (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, name);
            st.setInt(2, Rollno);
            st.setString(3, Class);
            st.setString(4, section);
            st.setString(5, gender);
            st.setString(6, DOB);
            st.setString(7, address);
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "The registration is successfully done..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int s_id) {
        try {
            String sql = "DELETE FROM student WHERE S_ID='" + s_id + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void updateStudent(int sid,String name,int rollno,String classs,String section,String Gender,String DOB,String Address){
        try{
            String sql="UPDATE student SET Name=?,Roll_No=?,Class=?,Section=?,Gender=?,DOB=?,Address=? where S_ID='"+sid+"'";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,rollno);
            pst.setString(3, classs);
            pst.setString(4,section);
            pst.setString(5,Gender);
            pst.setString(6, DOB);
            pst.setString(7, Address);
            JOptionPane.showMessageDialog(null,"Update successfully!!");
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertintoSubject(String sub_code ,String Subject) {
        try {
            String sql = "insert into subject(Sub_code, Subject) values (?,?)";
            PreparedStatement st = conn.prepareStatement(sql);


            st.setString(1, sub_code);
            st.setString(2, Subject);
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "The subject registration is successfully done..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteSubject(String sub_code) {
        try {
            String sql = "DELETE FROM subject WHERE S_ID='" + sub_code + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void updateSubject(String sub_code,String subject){
        try{
            String sql="UPDATE subject SET Sub_code=?,Subject=? where Sub_code='"+sub_code+"'";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1,sub_code);
            pst.setString(2, subject);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Updated Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void subject()
    {
        ArrayList<String> subjects=new ArrayList<>();
        subaaray = new String[subjects.size()];
        try{
            Database db=new Database();
            String sql="SELECT * FROM subject";
            db.rs = db.st.executeQuery(sql);
            while(db.rs.next()){
                String a=db.rs.getString("Subject");
                subjects.add(a);
            }
            for (int i =0; i < subjects.size(); i++)
                subaaray[i] = subjects.get(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertintoResult(int result,int studentRool,String subcode ){
        try{
            String sql="INSERT INTO result(Result_ID, Student_Id, Subject_Code) VALUES (?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1, result);
            st.setInt(2, studentRool);
            st.setString(3, subcode);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"successfully enter!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete_result(int result){

        try {
            String sql = "DELETE FROM result WHERE Result_ID='" + result + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"successfully deleted!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void UpdateREsult(int Result_ID,int Student_Id,String sub_code){
        try{
            String sql="UPDATE result SET Result_ID=? WHERE Student_Id='"+Student_Id+"'";
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setInt(1,Result_ID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Updated Successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }  

