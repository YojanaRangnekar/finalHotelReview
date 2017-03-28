
package project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Login extends JFrame implements ActionListener {

    Container c;

    JLabel title, user_login, user_reg, pwd_login, pwd_reg, LOGIN, REG, or;
    JTextField un_login, un_reg, name_txt;
    JPasswordField password_l, password_r;

    int reg = 0;

    static WritableWorkbook w;
    WritableSheet wsheet;

    JLabel lb1, lb2, lb3, lb_txt, test, name;
    Font font_home = new Font("Viner Hand ITC", Font.BOLD, 30);
    Font font_home1 = new Font("Viner Hand ITC", Font.ITALIC, 20);
    Color right = new Color(128, 0, 0);
    Color left = new Color(255, 218, 115);

    String u_l, p_l, u_r, p_r, n_r;

    JButton submit_l, submit_r;

    Color text = new Color(255, 218, 115);

    Login() throws IOException

    {

        Color backg = new Color(128, 0, 0);

        c = getContentPane();

        JPanel jp_btn = new JPanel();

        title = new JLabel();
        title.setText("EpiCurious");
        title.setFont(font_home);
        title.setForeground(text);
        title.setBounds(500, 25, 500, 50);

        jp_btn.add(title);

        LOGIN = new JLabel();
        LOGIN.setText("LOGIN");
        LOGIN.setFont(font_home);
        LOGIN.setForeground(text);

        LOGIN.setBounds(100, 100, 150, 50);

        jp_btn.add(LOGIN);

        jp_btn.setLayout(null);
        jp_btn.setBackground(right);
        user_login = new JLabel();
        user_login.setText("User Name:");
        user_login.setForeground(text);
        user_login.setFont(font_home);
        jp_btn.add(user_login);
        user_login.setBounds(20, 200, 300, 80);
        un_login = new JTextField(10);
        jp_btn.add(un_login);
        un_login.setBounds(200, 220, 150, 30);

        pwd_login = new JLabel();
        pwd_login.setText("Password:");
        pwd_login.setForeground(text);
        pwd_login.setFont(font_home);
        jp_btn.add(pwd_login);
        pwd_login.setBounds(20, 300, 300, 80);
        password_l = new JPasswordField(10);
        password_l.setEchoChar('*');
        jp_btn.add(password_l);
        password_l.setBounds(200, 320, 150, 30);

        submit_l = new JButton("Login");
        submit_l.setFont(font_home1);
        submit_l.setBounds(100, 380, 150, 50);
        submit_l.setBackground(Color.white);
        submit_l.setForeground(right);

        REG = new JLabel();
        REG.setText("REGISTER");
        REG.setFont(font_home);
        REG.setForeground(text);

        REG.setBounds(600, 100, 300, 50);

        jp_btn.add(REG);

        jp_btn.setLayout(null);

        jp_btn.setBackground(right);

        user_reg = new JLabel();
        name = new JLabel();
        name.setText("Name:");
        name.setForeground(text);
        name.setFont(font_home);
        name.setBounds(600, 200, 300, 80);
        jp_btn.add(name);

        name_txt = new JTextField(10);
        name_txt.setBounds(800, 220, 150, 30);
        jp_btn.add(name_txt);
        user_reg.setText("User Name:");
        user_reg.setForeground(text);
        user_reg.setFont(font_home);
        jp_btn.add(user_reg);
        user_reg.setBounds(600, 300, 300, 80);
        un_reg = new JTextField(10);
        jp_btn.add(un_reg);
        un_reg.setBounds(800, 320, 150, 30);

        pwd_reg = new JLabel();
        pwd_reg.setText("Password:");
        pwd_reg.setForeground(text);
        pwd_reg.setFont(font_home);
        jp_btn.add(pwd_reg);
        pwd_reg.setBounds(600, 400, 300, 80);
        password_r = new JPasswordField(10);
        password_r.setEchoChar('*');
        jp_btn.add(password_r);
        password_r.setBounds(800, 420, 150, 30);

        submit_r = new JButton("Register");
        submit_r.setFont(font_home1);
        submit_r.setBounds(700, 500, 150, 50);
        submit_r.setBackground(Color.white);
        submit_r.setForeground(right);

        or = new JLabel();
        or.setText("or");
        or.setForeground(text);
        or.setFont(font_home);
        jp_btn.add(or);
        or.setBounds(450, 300, 30, 50);

        submit_l.addActionListener(this);
        submit_r.addActionListener(this);

        jp_btn.add(submit_l);
        jp_btn.add(submit_r);

        c.add(jp_btn);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent ae)
    {
        try {

            if (ae.getSource().equals(submit_l))
            {
                u_l = un_login.getText();
                p_l = password_l.getText();

                if ((u_l).equalsIgnoreCase("") || p_l.equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(c, "Fields cannot be empty!");
                    un_login.setText("");
                    password_l.setText("");
                }

                else {

                    Workbook workbook = Workbook.getWorkbook(new File("resources/login.xls"));
                    Sheet sheet = workbook.getSheet(0);

                    int flag = 0;

                    int rows = sheet.getRows();
                    System.out.println("rows=" + rows);

                    for (int i = 0; i < rows; i++)
                    {

                        Cell cell1 = sheet.getCell(0, i);
                        String user = (cell1.getContents()).toString();

                        Cell cell2 = sheet.getCell(1, i);
                        String pwd = (cell2.getContents()).toString();
                        
                        Cell cell3 = sheet.getCell(2, i);
                        String userType = (cell3.getContents()).toString();

                        if (u_l.toString().equals(user) && p_l.toString().equals(pwd))
                        {
                            flag = 1;
                            HomePage1 h = new HomePage1(userType);
                            h.setVisible(true);
                            h.setExtendedState(6);
                            this.dispose();
                            break;

                        }

                    }//for

                    if (flag != 1)
                    {
                        JOptionPane.showMessageDialog(c, "LOGIN UNSUCCESSFUL!! Try again/Register.");
                        un_login.setText("");
                        password_l.setText("");
                        name_txt.setText("");
                    }
                }
            }

            if (ae.getSource().equals(submit_r))
            {
                u_r = un_reg.getText();
                p_r = password_r.getText();
                n_r = name_txt.getText();
                String userType = "user";
                if ((u_r).equalsIgnoreCase("") || p_r.equalsIgnoreCase("") || n_r.equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(c, "Fields cannot be empty!");
                    un_reg.setText("");
                    password_r.setText("");
                    name_txt.setText("");

                }

                else
                {
                 
                    File file = new File("Login.xls");
                    String abPath = file.getAbsolutePath();

                    File f1 = new File(abPath);
                    System.out.println("going to enter exists");
                    System.out.println(f1.exists());

                    Workbook workbook = Workbook.getWorkbook(new File("resources/login.xls"));
                    Sheet sheet = workbook.getSheet(0);

                    int rows_read = sheet.getRows();

                    w = Workbook.createWorkbook(new File("resources/login.xls"));
                    wsheet = w.createSheet("First Sheet", 0);

                    for (int row = 0; row < rows_read; row++)
                    {
                        Cell cell_u = sheet.getCell(0, row);
                        String user = (cell_u.getContents()).toString();

                        Cell cell_p = sheet.getCell(1, row);
                        String pwd = (cell_p.getContents()).toString();
                        Label m = new Label(0, row, user);
                        wsheet.addCell(m);
                        Label n = new Label(1, row, pwd);
                        wsheet.addCell(n);
                        Cell cell_ut = sheet.getCell(2, row);
                        String type = (cell_ut.getContents()).toString();
                        Label o = new Label(2, row, type);
                        wsheet.addCell(o);
                    }

                    int Rows = wsheet.getRows();

                    System.out.println("Rows " + Rows);

                    //read-write version

                    Label label_u = new Label(0, Rows, u_r);
                    wsheet.addCell(label_u);
                    Label label_p = new Label(1, Rows, p_r);
                    wsheet.addCell(label_p);
                    Label label_ut = new Label(2, Rows, userType);
                    wsheet.addCell(label_ut);

                    JOptionPane.showMessageDialog(c, "REGISTERED! PLEASE LOGIN");

                    un_reg.setText("");
                    password_r.setText("");
                    name_txt.setText("");

                    w.write();
                    w.close();

                }
            }
        }//try

        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String args[]) throws Exception
    {
        Login l = new Login();
        l.setTitle("LOGIN/SIGN_UP");
        l.setVisible(true);
        l.setExtendedState(6);
        ImageIcon image = new ImageIcon("images/E.gif");
        l.setIconImage(image.getImage());

    }
}
