
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame {

    JTextField player1Input, player2Input;
    JButton startButton;

    public WelcomePage() {
        setTitle(" X and O Showdown - Welcome Arena");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(30, 41, 59)); // Deep navy blue background

        //  Animated Game Title
        JLabel title = new JLabel(" X and O Ultimate Showdown ", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
        title.setForeground(new Color(255, 255, 255));
        title.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        //  Player input form panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 30, 80));

        JLabel p1Label = new JLabel(" Enter Player 1 Name:");
        p1Label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        p1Label.setForeground(Color.WHITE);
        JLabel p2Label = new JLabel(" Enter Player 2 Name:");
        p2Label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        p2Label.setForeground(Color.WHITE);

        player1Input = new JTextField();
        player1Input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        player1Input.setBackground(new Color(230, 230, 250));
        player1Input.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        player2Input = new JTextField();
        player2Input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        player2Input.setBackground(new Color(230, 230, 250));
        player2Input.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        formPanel.add(p1Label);
        formPanel.add(player1Input);
        formPanel.add(p2Label);
        formPanel.add(player2Input);
        add(formPanel, BorderLayout.CENTER);

        // Start button setup
        startButton = new JButton(" Start Game Now");
        startButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
        startButton.setBackground(new Color(72, 219, 251)); // Vibrant cyan
        startButton.setForeground(Color.BLACK);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 168, 255), 2),
                BorderFactory.createEmptyBorder(10, 30, 10, 30)
        ));
        startButton.setToolTipText("Let the battle begin!");

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 40, 10));
        btnPanel.add(startButton);
        add(btnPanel, BorderLayout.SOUTH);

        //Hover effect
        startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                startButton.setBackground(new Color(0, 210, 255));
            }
            public void mouseExited(MouseEvent evt) {
                startButton.setBackground(new Color(72, 219, 251));
            }
        });

        //Save names and launch game
        startButton.addActionListener(e -> {
            GameState.playerOneName = player1Input.getText().trim().isEmpty() ? "Player 1" : player1Input.getText().trim();
            GameState.playerTwoName = player2Input.getText().trim().isEmpty() ? "Player 2" : player2Input.getText().trim();
            dispose();
            new XandO();
        });

        setVisible(true);
    }
}
