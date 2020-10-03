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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
/**
 *
 * @author pema
 */
public class MenuBar implements ActionListener {
    JFrame frame=new JFrame("Menu BAr");
    JMenuBar menubar;
    JMenu Student,Subject,ShowStudent,Show_Subject,AddResult,ShowResult,Find_Student;
    MenuBar(){
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
        frame.setBounds(150,150,650,300);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f= new Font("Serif",Font.BOLD,13);

        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        Student=new JMenu("StudentRegistration");
        menubar.add(Student);
        menubar.setVisible(true);
        Student.setFont(f);
        Student.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentRegistration();
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        Subject=new JMenu("Subject");
        menubar.add(Subject);
        menubar.setVisible(true);
        Subject.setFont(f);
        Subject.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Subject();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddResult=new JMenu("AddResult");
        menubar.add(AddResult);
        menubar.setVisible(true);
        AddResult.setFont(f);
        AddResult.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                    new ResultAdd();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ShowStudent=new JMenu("ShowStudent");
        menubar.add(ShowStudent);
        menubar.setVisible(true);
        ShowStudent.setFont(f);
        ShowStudent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new StudentShow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Show_Subject=new JMenu("ShowSubject");
        menubar.add(Show_Subject);
        menubar.setVisible(true);
        Show_Subject.setFont(f);
        Show_Subject.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new SubjectShow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ShowResult=new JMenu("ShowResult");
        menubar.add(ShowResult);
        menubar.setVisible(true);
        ShowResult.setFont(f);
        ShowResult.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new ShowResult();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Find_Student=new JMenu("Find Student");
        menubar.add(Find_Student);
        Find_Student.setVisible(true);
        Find_Student.setFont(f);
        Find_Student.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new SearchStudent();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    String ch=e.getActionCommand();
//    if(ch=="Student Registration"){
//        new Student_regis();
//        frame.dispose();
//    }
    }
}

