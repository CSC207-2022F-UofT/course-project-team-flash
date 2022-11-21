package screens;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel {
    private String textInput;
    private static final int TEXT_FIELD_LENGTH = 10;

    public DeckScreen() {
        JButton backButton = new JButton("Back");
        JButton deckCreationButton = new JButton("New Deck");
        this.add(backButton);
        this.add(deckCreationButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                for (Component c : getParent().getComponents()) {
                    if (c instanceof MainMenuScreen) {
                        c.setVisible(true);
                        return;
                    }
                }
            }
        });

        deckCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseDeckCreation();
            }
        });
    }

    private void chooseDeckCreation() {

    }
}
