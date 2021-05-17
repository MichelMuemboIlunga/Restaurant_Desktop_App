package com.MIMdev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    //

    Container container = getContentPane();
    JPanel panel = new JPanel();
    ImageIcon food = new ImageIcon("src/Food.png");
    JLabel label = new JLabel();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();

    // video link
    // https://youtu.be/Kmgo00avvEw


    // constructor

    login() {

        viewPage();
        setLayoutManger();
        setBoundsAndOthers();
        addComponent();
    }

    // set text and logo page
    // try to fix this portion of code
    public void viewPage() {

        // set the title of the page
        label.setText("ANGRY FAST FOOD ");
        label.setFont(new Font("Lato", Font.ITALIC, 30));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        // set image logo
        label.setIcon(food);
        // set the title of the page
    }

    // set layout manager method

    public void setLayoutManger() {

        container.setLayout(null);



    }

    // set size and location method

    public void setBoundsAndOthers() {

        userIDLabel.setBounds(340, 300, 100, 25);
        userIDLabel.setFont(new Font("Lato", Font.ITALIC, 15));
        userIDLabel.setForeground(Color.WHITE);

        userPasswordLabel.setBounds(340, 350, 100, 25);
        userPasswordLabel.setFont(new Font("Lato", Font.ITALIC, 15));
        userPasswordLabel.setForeground(Color.WHITE);

        messageLabel.setBounds(380, 500, 450, 35);
        messageLabel.setFont(new Font("Lato", Font.ITALIC, 25));

        userIDField.setBounds(425, 300, 250, 30);
        userIDField.setBackground(Color.GRAY);
        userIDField.setFont(new Font("Lato", Font.CENTER_BASELINE, 20));
        userIDField.setForeground(new Color(19, 22, 54));
        userIDField.setCaretColor(new Color(19, 22, 54));
        userIDField.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));

        userPasswordField.setBounds(425, 350, 250, 30);
        userPasswordField.setBackground(Color.GRAY);
        userPasswordField.setFont(new Font("Lato", Font.CENTER_BASELINE, 20));
        userPasswordField.setForeground(new Color(19, 22, 54));
        userPasswordField.setCaretColor(new Color(19, 22, 54));
        userPasswordField.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));


        loginButton.setBounds(500, 400, 100, 35);
        loginButton.setFocusable(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);

        resetButton.setBounds(500, 450, 100, 35);
        resetButton.setFocusable(false);
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(this);

    }

    // adding component method

    public void addComponent() {
        container.add(label);
        container.add(userIDLabel);
        container.add(userPasswordLabel);
        container.add(messageLabel);
        container.add(userIDField);
        container.add(userPasswordField);
        container.add(loginButton);
        container.add(resetButton);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // reset field if reset button was clicked
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        // login btn was clicked

        if (e.getSource() == loginButton) {
            // create connection
            try {
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_app",
                        "root", "Your Mysql Password");
                String username = userIDField.getText();
                String password = userPasswordField.getText();

                Statement stm = con.createStatement();

                // query

                String sql = "Select * from Admin where username ='" + username + "' and password='" + password + "'";
                ResultSet result = stm.executeQuery(sql);

                if (result.next()) {
                    dispose();
                    // create a new window
                    Dashboard main_page = new Dashboard();
                    main_page.show();
                    // display message error if login failed
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong username or Password");
                }
                // close connection
                con.close();


            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }

        }
    }
}
