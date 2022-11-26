package screens;

import createDeck.CreateDeckController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel {

    // Controllers required by this Jpanel
    private CreateDeckController createDeckController;

    // Decks
    private ArrayList<String> deckNames;

    private ArrayList<JButton> deckButtons;
    private static final int TEXT_FIELD_LENGTH = 10;

    public DeckScreen(CreateDeckController createDeckController) {
        this.deckNames = new ArrayList<>();
        this.deckButtons = new ArrayList<>();
        this.createDeckController = createDeckController;
        drawComponents();
    }

    public void setController(CreateDeckController createDeckController) {
        this.createDeckController = createDeckController;
    }

    public void reconstruct(boolean delete, String deckName) {
        if (delete) {
            deckNames.remove(deckName);
        } else {
            deckNames.add(deckName);
        }
        drawComponents();
    }

    private void drawComponents() {
        // creates/recreates the components of the Jpanel
        this.removeAll();
        JButton backButton = new JButton("Back");
        JButton deckCreationButton = new JButton("New Deck");
        this.add(backButton);
        this.add(deckCreationButton);
        for (String name : deckNames) {
            JButton deckButton = new JButton(name);
            deckButtons.add(deckButton);
            this.add(deckButton);
        }
        // re-renders the screen with new components
        this.revalidate();

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

        for (JButton button : deckButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    for (Component c : getParent().getComponents()) {
                        //if (c instanceof CardScreen) {
                        //    c.setVisible(true);
                        //    return;
                        //}
                    }
                }
            });
        }
    }


    private void chooseDeckCreation() {
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
        JButton createButton = new JButton("Create Deck");
        createNewDeck.add(prompt);
        createNewDeck.add(createDeckTextField);
        createNewDeck.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDeckController.create(createDeckTextField.getText());
            }
        });

        newDeckDialog.pack();
        newDeckDialog.setModal(true);
        newDeckDialog.setVisible(true);


    }
}
