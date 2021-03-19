package com.MIMdev;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    JLabel label = new JLabel();
    JFrame frame = new JFrame();

    Dashboard() {
        viewPage();
    }


    //        // create the interface
    public void viewPage() {

        // set the title of the page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setTitle("ANGRY FAST FOOD");
        this.setSize(1000, 800);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(19, 22, 54));

        ImageIcon food = new ImageIcon("src/Food.png");
        this.setIconImage(food.getImage());
        this.setVisible(true);

        label.setText("Welcome To dashboard");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Lato", Font.ITALIC, 15));
        label.setForeground(Color.WHITE);

        this.add(label);
    }
}
