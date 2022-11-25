package screens;

import createDeck.CreateDeckController;
import deleteDeck.DeleteDeckController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel {

    // Controllers required by this Jpanel
    private CreateDeckController createDeckController;
    private DeleteDeckController deleteDeckController;

    // Decks
    private ArrayList<String> deckNames;

    private ArrayList<JButton> deckButtons;

    private ArrayList<JButton> deckSettingsButtons;
    private static final int TEXT_FIELD_LENGTH = 10;

    public DeckScreen(CreateDeckController createDeckController, DeleteDeckController deleteDeckControler) {
        this.deckNames = new ArrayList<>();
        this.deckButtons = new ArrayList<>();
        this.deckSettingsButtons = new ArrayList<>();
        this.createDeckController = createDeckController;
        this.deleteDeckController = deleteDeckControler;
        drawComponents();
    }

    public void setController(CreateDeckController createDeckController, DeleteDeckController deleteDeckController) {
        this.createDeckController = createDeckController;
        this.deleteDeckController = deleteDeckController;
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
        deckButtons.clear();
        deckSettingsButtons.clear();
        JButton backButton = new JButton("Back");
        JButton deckCreationButton = new JButton("New Deck");
        this.add(backButton);
        this.add(deckCreationButton);
        for (String name : deckNames) {
            JButton deckButton = new JButton(name);
            JButton deckSettingsButton = new JButton("...");
            deckSettingsButton.setName(name);
            deckButtons.add(deckButton);
            deckSettingsButtons.add(deckSettingsButton);
            this.add(deckButton);
            this.add(deckSettingsButton);
        }
        // re-renders the screen with new components
        this.revalidate();
        this.repaint();

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
            public void actionPerformed(ActionEvent e) { chooseDeckCreation(); }
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

        for (JButton button : deckSettingsButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    JFrame deckSettingsFrame = new JFrame();
                    JDialog newDeckDialog = new JDialog(deckSettingsFrame);

                    JTabbedPane optionTabs = new JTabbedPane();

                    JPanel renameDeck = new JPanel();
                    JPanel deleteDeck = new JPanel();

                    optionTabs.add("Rename Deck", renameDeck);
                    optionTabs.add("Delete Deck", deleteDeck);

                    newDeckDialog.add(optionTabs);

                    JLabel prompt = new JLabel("Enter a new name for the deck:");
                    JTextField createDeckTextField = new JTextField("", TEXT_FIELD_LENGTH);
                    JButton renameButton = new JButton("Rename Deck");
                    renameDeck.add(prompt);
                    renameDeck.add(createDeckTextField);
                    renameDeck.add(renameButton);

                    JButton deleteButton = new JButton("Delete Deck" + button.getName());
                    deleteDeck.add(deleteButton);

                    renameButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //createDeckController.create(createDeckTextField.getText());
                            deckSettingsFrame.dispose();
                        }
                    });

                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteDeckController.delete(button.getName());
                            deckSettingsFrame.dispose();
                        }
                    });

                    newDeckDialog.pack();
                    newDeckDialog.setModal(true);
                    newDeckDialog.setVisible(true);



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
                newDeckFrame.dispose();
            }
        });

        newDeckDialog.pack();
        newDeckDialog.setModal(true);
        newDeckDialog.setVisible(true);


    }
}
