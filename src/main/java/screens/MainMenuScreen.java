package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainMenuScreen extends JPanel {
    private String textInput;
    private static final int TEXT_FIELD_LENGTH = 10;

    public MainMenuScreen() {

        JButton decksButton = new JButton("Decks");
        JButton quizButton = new JButton("Quizzes");
        this.add(decksButton, BorderLayout.CENTER);
        this.add(quizButton, BorderLayout.CENTER);

        decksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                for (Component c : getParent().getComponents()) {
                    if (c instanceof DeckScreen) {
                        c.setVisible(true);
                        return;
                    }
                }
            }
        });

        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                for (Component c : getParent().getComponents()) {
                    if (c instanceof QuizScreen) {
                        c.setVisible(true);
                        return;
                    }
                }
            }
        });
    }
}
