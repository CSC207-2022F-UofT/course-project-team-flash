package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel implements ActionListener {
    public DeckScreen(){
        JPopupMenu deckCreationMenu = new JPopupMenu("Deck Creation");
        JMenuItem createNewDeck = new JMenuItem("Create New");
        JMenuItem importDeck = new JMenuItem("Import");

        deckCreationMenu.add(createNewDeck);
        deckCreationMenu.add(importDeck);

        JButton deckCreationButton = new JButton("New Deck");
        this.add(deckCreationButton);
        deckCreationButton.setComponentPopupMenu(deckCreationMenu);


    }

    public void actionPerformed(ActionEvent evt){
        System.out.println("x");
    }
}
