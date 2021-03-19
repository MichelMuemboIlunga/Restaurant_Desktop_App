package com.MIMdev;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // extension for login page

        login my_login = new login();

        // create the interface

        my_login.setTitle("ANGRY FAST FOOD");
        my_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        my_login.setSize(1000, 800);
        my_login.setResizable(false);
        my_login.getContentPane().setBackground(new Color(19, 22, 54));

        ImageIcon food = new ImageIcon("src/Food.png");
        my_login.setIconImage(food.getImage());
        my_login.setVisible(true);


    }
}
