package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainMenuScreen extends JPanel {
    private static final int BUTTON_WIDTH = 350;
    private static final int BUTTON_HEIGHT = 500;
    private static final int BORDER_THICKNESS = 7;

    public MainMenuScreen() {
        JButton decksButton = new JButton("Decks");
        JButton quizButton = new JButton("Quizzes");

        customize(decksButton, quizButton);
        addButtons(decksButton, quizButton);
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

    private void customize(JButton decksButton, JButton quizButton) {
        this.setBackground(new Color(32, 32, 32));
        Color colour = this.getBackground();

        decksButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        decksButton.setBorder(BorderFactory.createLineBorder(colour, BORDER_THICKNESS));
        decksButton.setForeground(Color.white);
        decksButton.setBackground(new Color(88, 88, 88));

        quizButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        quizButton.setBorder(BorderFactory.createLineBorder(colour, BORDER_THICKNESS));
        quizButton.setForeground(Color.white);
        quizButton.setBackground(new Color(88, 88, 88));
    }

    private void addButtons(JButton decksButton, JButton quizButton) {
        this.add(decksButton);
        this.add(quizButton);
    }
}
