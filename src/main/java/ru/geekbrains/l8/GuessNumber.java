package ru.geekbrains.l8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame {
    private JTextField txtGuess;
    private JLabel lblOutput;
    private int theNumber;
    private JButton btnPlayAgain;

    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";
        int guess = Integer.parseInt(guessText);

        if (guess < theNumber)
            message = guess + " is too low. Try again.";
        else if (guess > theNumber)
            message = guess + " is too high. Try again.";
        else {
            message = guess + " is correct. You win!.";
            btnPlayAgain.setVisible(true);
        }

        lblOutput.setText(message);
    }

    public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
    }

    public GuessNumber() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ваше имя Hi-Lo Guessing Game");
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Ваше Имя Hi-Lo Guessing Game");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel.setBounds(0, 0, 434, 21);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(36, 45, 247, 21);
        getContentPane().add(lblNewLabel_1);

        txtGuess = new JTextField();
        txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
        txtGuess.setBounds(293, 47, 65, 19);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        JButton btnGuess = new JButton("Guess!");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnGuess.setFont(new Font("Arial", Font.BOLD, 13));
        btnGuess.setBounds(168, 111, 98, 36);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Enter a number above and click Guess!");
        lblOutput.setFont(new Font("Arial", Font.PLAIN, 12));
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(0, 171, 434, 21);
        getContentPane().add(lblOutput);

        btnPlayAgain = new JButton("Play Again?");
        btnPlayAgain.setVisible(false);
        btnPlayAgain.setFont(new Font("Arial", Font.BOLD, 11));
        btnPlayAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
                theNumber = (int)(Math.random() * 100 + 1);
                lblOutput.setText("");
                txtGuess.setText("");
                btnPlayAgain.setVisible(false);
                btnPlayAgain.setVisible(false);
            }
        });


        btnPlayAgain.setBounds(168, 203, 98, 36);
        getContentPane().add(btnPlayAgain);
    }


    }
