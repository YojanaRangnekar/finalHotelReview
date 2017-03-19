/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beproject;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class Poptates_Homepage1_try extends JFrame implements ActionListener

{
    Font font_head = new Font("Tekton Pro", Font.BOLD, 20);
    Container c, c1;
    Button view_result_poptates, back;
    JPanel jp1, jp2, jp3;
    JLabel pop_pic, pop_details;
    Font f;
    ImageIcon pop_icon;
    Button open1;
    JMenuBar mbar;
    JMenu file;
    JMenuItem open, exit;
    JTextArea text_area;
    JScrollPane sp1;
    String command;
    String str = "";
    static int a;

    Poptates_Homepage1_try(int id, String rev) throws IOException
    {

        pop_icon = new ImageIcon("images/poptates_img.jpg");

        String path = new String();
        JExcelAPIDemo j1;

        try {
            if (id == 1)
            {
                path = "images/poptates_img.jpg";
                pop_icon = new ImageIcon("images/poptates_img.jpg");
            }
            if (id == 2)
            {
                path = "images/wilddining_img.jpg";
                pop_icon = new ImageIcon("images/wilddining.jpg");
            }
            if (id == 3)
            {
                path = "images/candies_img.jpg";
                pop_icon = new ImageIcon("images/candies-bandra.jpg");
            }
            if (id == 4)
            {
                path = "images/blue-frog_img.jpg";
                pop_icon = new ImageIcon("images/blue-frog-logo.jpg");
            }
            if (id == 0)
                j1 = new JExcelAPIDemo(0, rev);
        }
        catch (Exception e) {
        }
        a = id;

        Font font_home2 = new Font("Calibri", Font.BOLD, 20);
        Color backg = new Color(128, 0, 0);

        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

        jp1 = new JPanel();

        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));

        jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());

        //jp2.setBounds(20, 20, 80, 80);
        jp2.setBounds(20, 20, 50, 50);
        jp2.setBackground(backg);

        text_area = new JTextArea(180, 49);
        //text_area = new JTextArea(90, 35);
        f = new Font("Calibri", Font.PLAIN, 15);
        text_area.setFont(font_home2);
        jp2.add(text_area, BorderLayout.CENTER);

        sp1 = new JScrollPane(text_area);
        sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jp2.add(sp1, BorderLayout.EAST);

        open1 = new Button("open");
        open1.setFont(font_head);
        open1.setForeground(Color.white);
        jp2.add(open1, BorderLayout.CENTER);
        open1.setBackground(backg);
        open1.addActionListener(this);

        BufferedImage img = null;
        BufferedImage img1 = null;
        try {

            if (id == 1){
                img = ImageIO.read(new File("images/poptates_img.jpg"));
                img1 = ImageIO.read(new File("images/poptates_img_2.jpg"));
            }
            if (id == 2){
                img = ImageIO.read(new File("images/wilddining_img.jpg"));
                img1 = ImageIO.read(new File("images/wilddining_img_2.jpg"));                
            }
            if (id == 3){
                img = ImageIO.read(new File("images/candies_img.jpg"));
                img1 = ImageIO.read(new File("images/candies_img2.jpg"));                
            }
            if (id == 4){
                img = ImageIO.read(new File("images/bluefrog_img.jpg"));
                img1 = ImageIO.read(new File("images/bluefrog_img2.jpg"));                
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        pop_pic = new JLabel();
        pop_pic.setIcon(imageIcon);

        jp1.add(pop_pic);
        jp1.setBackground(backg);

        
        Image dimg1 = img1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(dimg1);
        pop_details = new JLabel();
        pop_details.setIcon(imageIcon1);
        pop_details.setLocation(0, 150);

        jp1.add(pop_details);
        jp1.setBackground(backg);

        view_result_poptates = new Button("VIEW RESULT");
        jp1.add(view_result_poptates);
        view_result_poptates.setBackground(backg);
        view_result_poptates.setForeground(Color.white);
        view_result_poptates.setFont(font_home2);
        view_result_poptates.setBounds(20, 600, 60, 30);
        view_result_poptates.addActionListener(this);

        back = new Button("BACK");
        jp1.add(back);
        back.setBackground(backg);
        back.setForeground(Color.white);
        back.setFont(font_home2);
        back.setBounds(20, 600, 60, 30);
        back.addActionListener(this);

        c.add(jp2, BorderLayout.WEST);

        c.add(jp1, BorderLayout.WEST);
        

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == open1)
        {

            String str1, str2, str4;
            String str3 = new String();
            int len;
            try {
                str4 = "";
                if (a == 1)
                    str3 = "resources/Poptates.txt";
                if (a == 2)
                    str3 = "resources/Wilddining.txt";
                if (a == 3)
                    str3 = "resources/Candies.txt";
                if (a == 4)
                    str3 = "resources/Bluefrog.txt";

                File f = new File(str3);
                FileReader fr = new FileReader(f);
                BufferedReader in = new BufferedReader(fr);
                String line;
                while ((line = in.readLine()) != null)
                {
                    str4 = str4 + line + "\n";
                }
                text_area.setText(str4);

            }
            catch (Exception e)
            {
            }

        }

        //if view result is clicked

        if (ae.getSource() == view_result_poptates)
        {
            try
            {
                //this.dispose();

                JExcelAPIDemo j = new JExcelAPIDemo(a, "");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        if (ae.getSource() == back)
        {
            try {
                HomePage1 h = new HomePage1();
                h.setVisible(true);
                h.setExtendedState(6);
            }
            catch (Exception e)
            {

            }
            this.dispose();
        }

    }

    public static void main(String args[]) throws IOException
    {
        Poptates_Homepage1_try pop = new Poptates_Homepage1_try(1, "");

        Color backg = new Color(190, 50, 80);

        pop.setBackground(backg);
        pop.setTitle("POPTATES HOMEPAGE");
        pop.setVisible(true);
        pop.setExtendedState(6);

        ImageIcon image = new ImageIcon("images/E.gif");
        pop.setIconImage(image.getImage());

    }

}
