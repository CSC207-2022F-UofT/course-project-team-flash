package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel{

    private String textInput;
    private static final int TEXT_FIELD_LENGTH = 10;
    public DeckScreen(){
        JButton deckCreationButton = new JButton("New Deck");
        this.add(deckCreationButton);

        deckCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseDeckCreation();
            }
        });
    }

    private void chooseDeckCreation(){
        JFrame newDeckFrame = new JFrame();
        JDialog newDeckDialog = new JDialog(newDeckFrame);

        JTabbedPane optionTabs = new JTabbedPane();

        JPanel createNewDeck = new JPanel();
        JPanel importNewDeck = new JPanel();

        optionTabs.add("Create New Deck", createNewDeck);
        optionTabs.add("Import Deck", importNewDeck);

        newDeckDialog.add(optionTabs);

        JLabel prompt = new JLabel("Enter a name for the new deck:");
        JTextField createDeckTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JButton createDeckButton = new JButton("Create Deck");
        createNewDeck.add(prompt);
        createNewDeck.add(createDeckTextField);
        createNewDeck.add(createDeckButton);

        newDeckDialog.pack();
        newDeckDialog.setModal(true);
        newDeckDialog.setVisible(true);
    }
}
