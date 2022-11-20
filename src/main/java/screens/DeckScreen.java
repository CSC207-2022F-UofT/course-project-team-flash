package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel{
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

    public void chooseDeckCreation(){
        JFrame newDeckFrame = new JFrame();
        JDialog newDeckDialog = new JDialog(newDeckFrame);

        JTabbedPane optionTabs = new JTabbedPane();

        JPanel createNewDeck = new JPanel();
        JPanel importNewDeck = new JPanel();

        optionTabs.add("Create New Deck", createNewDeck);
        optionTabs.add("Import Deck", importNewDeck);

        newDeckDialog.add(optionTabs);

        newDeckDialog.pack();
        newDeckDialog.setModal(true);
        newDeckDialog.setVisible(true);
    }
}
