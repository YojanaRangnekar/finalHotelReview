/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beproject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author user
 */
public class HomePage1 extends JFrame implements ActionListener
{

    Container c;

    JButton poptates_Btn, wild_dining_Btn, blue_frog_Btn, candies_Btn;
    JButton test_Btn;

    JLabel lb1, lb2, lb3, lb_txt, test;
    Font font_home = new Font("Viner Hand ITC", Font.BOLD, 30);
    Font font_home1 = new Font("Viner Hand ITC", Font.ITALIC, 20);
    Color right = new Color(128, 0, 0);
    Color left = new Color(255, 218, 115);
    String review;
    JTextField txt;

    HomePage1() throws IOException
    {

        BufferedImage img = null;
        try {
            File file = new File("images/E.gif");
            String abPath = file.getAbsolutePath();
            img = ImageIO.read(new File(abPath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(1100, 1000,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        setContentPane(new JLabel(imageIcon));

        c = getContentPane();
        c.setLayout(new GridLayout());

        JPanel jp = new JPanel();
        jp.setBackground(left);
        JPanel jp_btn = new JPanel();

        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("images/top.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg1 = img1.getScaledInstance(450, 150,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(dimg1);
        lb2 = new JLabel(imageIcon1);

        lb_txt = new JLabel();
        lb_txt.setText("Click on a restaurant below.");

        jp_btn.add(lb_txt);
        lb_txt.setBounds(50, 25, 800, 30);
        lb_txt.setFont(font_home);
        lb_txt.setForeground(left);

        test = new JLabel();
        String s = "Would you like to test a review?";
        test.setText(s);
        jp_btn.add(test);
        test.setBounds(10, 550, 1000, 30);
        test.setFont(font_home);
        test.setForeground(left);

        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File("images/E.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg2 = img2.getScaledInstance(500, 300,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon2 = new ImageIcon(dimg2);
        lb3 = new JLabel(imageIcon2);

        jp.setLayout(new BorderLayout());
        jp_btn.setLayout(null);
        //in_jp.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jp.add(lb2, BorderLayout.CENTER);
        jp.add(lb3, BorderLayout.NORTH);
        jp_btn.setBackground(right);

        poptates_Btn = new JButton("Poptates");
        wild_dining_Btn = new JButton("Wild Dining");
        blue_frog_Btn = new JButton("Blue Frog");
        candies_Btn = new JButton("Candies");

        poptates_Btn.setFont(font_home1);

        wild_dining_Btn.setFont(font_home1);
        blue_frog_Btn.setFont(font_home1);
        candies_Btn.setFont(font_home1);

        poptates_Btn.setBounds(100, 100, 200, 50);
        wild_dining_Btn.setBounds(100, 200, 200, 50);
        blue_frog_Btn.setBounds(100, 400, 200, 50);
        candies_Btn.setBounds(100, 300, 200, 50);

        txt = new JTextField(100);
        txt.setBounds(50, 600, 400, 30);

        test_Btn = new JButton("Submit");
        test_Btn.setFont(font_home1);
        test_Btn.setBounds(100, 640, 200, 50);
        test_Btn.setBackground(left);
        test_Btn.setForeground(right);

        poptates_Btn.setBackground(Color.white);
        poptates_Btn.setForeground(right);
        wild_dining_Btn.setBackground
                (Color.white);
        wild_dining_Btn.setForeground(right);
        blue_frog_Btn.setBackground
                (Color.white);
        blue_frog_Btn.setForeground(right);
        candies_Btn.setBackground
                (Color.white);
        candies_Btn.setForeground(right);

        poptates_Btn.addActionListener(this);
        wild_dining_Btn.addActionListener(this);
        blue_frog_Btn.addActionListener(this);
        candies_Btn.addActionListener(this);
        test_Btn.addActionListener(this);

        jp_btn.add(poptates_Btn);
        jp_btn.add(wild_dining_Btn);
        jp_btn.add(blue_frog_Btn);
        jp_btn.add(candies_Btn);
        jp_btn.add(txt);
        jp_btn.add(test_Btn);

        c.add(jp);
        c.add(jp_btn);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if (ae.getSource() == poptates_Btn)
        {
            // Poptates    

            try {
                Poptates_Homepage1_try obj = new Poptates_Homepage1_try(1, "");
                obj.setVisible(true);
                obj.setExtendedState(6);
            }
            catch (Exception e) {
                System.out.println("Exception");
            }

            this.dispose();
        }

        if (ae.getSource() == wild_dining_Btn)
        {
            //   Wild Dining  

            try {
                Poptates_Homepage1_try obj = new Poptates_Homepage1_try(2, "");
                obj.setVisible(true);
                obj.setExtendedState(6);
            }
            catch (Exception e) {
            }

            this.dispose();
        }

        if (ae.getSource() == blue_frog_Btn)
        {
            // Blue Frog

            try {
                Poptates_Homepage1_try obj = new Poptates_Homepage1_try(4, "");
                obj.setVisible(true);
                obj.setExtendedState(6);
            }
            catch (Exception e) {
            }

            this.dispose();

        }

        if (ae.getSource() == candies_Btn)
        {
            // candies 

            try {
                Poptates_Homepage1_try obj = new Poptates_Homepage1_try(3, "");
                obj.setVisible(true);
                obj.setExtendedState(6);
            }
            catch (Exception e) {
            }

            this.dispose();
        }

        if (ae.getSource() == test_Btn)
        {
            review = txt.getText();
            if (review.equals(""))
            {
                JOptionPane.showMessageDialog(c, "Invalid input!");
                txt.requestFocus();
            }

            try {
                JExcelAPIDemo j1 = new JExcelAPIDemo(0, review);
            }
            catch (Exception e)
            {

            }

        }

    }

    public static void main(String args[]) throws IOException
    {
        HomePage1 f = new HomePage1();

        Color backg = new Color(190, 50, 80);

        f.setBackground(backg);
        f.setTitle("HOMEPAGE");
        f.setVisible(true);
        f.setExtendedState(6);

        File file = new File("E.gif");
        String path = file.getAbsolutePath();
        ImageIcon image = new ImageIcon("images/E.gif");
        f.setIconImage(image.getImage());

    }

}
