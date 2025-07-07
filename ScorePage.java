
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScorePage extends JFrame {

    JLabel name1, name2, score1, score2, drawLabel;
    JButton playAgainBtn, quitBtn;

    public ScorePage() {
        setTitle("🎮 Match Result");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(30, 30, 45));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Player 1
        name1 = new JLabel(" " + GameState.playerOneName);
        name1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        name1.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        add(name1, gbc);

        score1 = new JLabel("Wins: " + GameState.playerOneScore);
        score1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        score1.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(score1, gbc);

        // Player 2
        name2 = new JLabel(" " + GameState.playerTwoName);
        name2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        name2.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        add(name2, gbc);

        score2 = new JLabel("Wins: " + GameState.playerTwoScore);
        score2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        score2.setForeground(Color.WHITE);
        gbc.gridx = 1;
        add(score2, gbc);

        // Draws
        drawLabel = new JLabel(" Draws: " + GameState.draws);
        drawLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        drawLabel.setForeground(Color.LIGHT_GRAY);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(drawLabel, gbc);

        // Show Winner pop-up AFTER window becomes visible
        SwingUtilities.invokeLater(() -> {
            String winnerMessage;
            if (GameState.playerOneScore > GameState.playerTwoScore) {
                winnerMessage = " " + GameState.playerOneName + " wins the match!";
            } else if (GameState.playerTwoScore > GameState.playerOneScore) {
                winnerMessage = " " + GameState.playerTwoName + " wins the match!";
            } else {
                winnerMessage = " It's a draw!";
            }
            JOptionPane.showMessageDialog(this, winnerMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        });

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(30, 30, 45));

        playAgainBtn = new JButton(" Play Again");
        playAgainBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        playAgainBtn.setBackground(new Color(0x34ace0));
        playAgainBtn.setForeground(Color.WHITE);
        playAgainBtn.setFocusPainted(false);
        playAgainBtn.addActionListener(e -> {
            dispose();
            new XandO();
        });

        quitBtn = new JButton(" Quit");
        quitBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        quitBtn.setBackground(new Color(220, 53, 69));
        quitBtn.setForeground(Color.WHITE);
        quitBtn.setFocusPainted(false);
        quitBtn.addActionListener(e -> System.exit(0));

        buttonPanel.add(playAgainBtn);
        buttonPanel.add(quitBtn);

        gbc.gridy = 3;
        add(buttonPanel, gbc);

        setVisible(true);
    }
}
