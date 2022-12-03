package screens;

import createDeck.CreateDeckController;
import deleteDeck.DeleteDeckController;
import editDeck.EditDeckController;
import enterDeck.EnterDeckController;

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
    private EditDeckController editDeckController;
    private EnterDeckController enterDeckController;

    // Decks
    private final ArrayList<String> deckNames;

    // Deck buttons
    private final ArrayList<JButton> deckButtons;
    private final ArrayList<JButton> deckSettingsButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;
    private final GridBagConstraints gridBagConstraints;

    public DeckScreen(CreateDeckController createDeckController,
                      DeleteDeckController deleteDeckController,
                      EditDeckController editDeckController,
                      EnterDeckController enterDeckController) {
        super(new GridBagLayout());
        customize();
        this.gridBagConstraints = new GridBagConstraints();
        this.deckNames = new ArrayList<>();
        this.deckButtons = new ArrayList<>();
        this.deckSettingsButtons = new ArrayList<>();

        this.createDeckController = createDeckController;
        this.deleteDeckController = deleteDeckController;
        this.editDeckController = editDeckController;
        this.enterDeckController = enterDeckController;
        drawComponents();
    }

    public void setController(CreateDeckController createDeckController,
                              DeleteDeckController deleteDeckController,
                              EditDeckController editDeckController,
                              EnterDeckController enterDeckController) {
        this.createDeckController = createDeckController;
        this.deleteDeckController = deleteDeckController;
        this.editDeckController = editDeckController;
        this.enterDeckController = enterDeckController;
    }

    public void reconstructDecks(boolean delete, String deckName) {
        if (delete) {
            deckNames.remove(deckName);
        } else {
            deckNames.add(deckName);
        }
        drawComponents();
    }

    // helper method for setting constraints on layout components
    private void setConstraints(int anchor, int fill, int gridWidth,
                                int gridHeight, int gridX, int gridY,
                                double weightX, double weightY) {
        this.gridBagConstraints.anchor = anchor;
        this.gridBagConstraints.fill = fill;
        this.gridBagConstraints.gridwidth = gridWidth;
        this.gridBagConstraints.gridheight = gridHeight;
        this.gridBagConstraints.gridx = gridX;
        this.gridBagConstraints.gridy = gridY;
        this.gridBagConstraints.weightx = weightX;
        this.gridBagConstraints.weighty = weightY;
    }

    private void drawComponents() {
        // Resets the components of the Jpanel
        clear();

        // Initial button set up
        JButton backButton = new JButton("Back");
        JButton deckCreationButton = new JButton("Create Deck");
        customizeButtons(backButton, deckCreationButton);
        addButtons(backButton, deckCreationButton);

        // The "squashPanel" for squashing components flush to the top
        JPanel squashPanel = new JPanel(new GridBagLayout());
        customizeSquashPanel(squashPanel);
        addSquashPanel(squashPanel);

        // Set up for deck buttons (for listing decks)
        loopSetUp();

        addDeckButtons();

        // Re-renders the screen with new components
        updateScreen();

        // All Buttons
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
                        if (c instanceof CardScreen) {
                            enterDeckController.enter(button.getText());
                            ((CardScreen) c).setDeck(button.getText());
                            c.setVisible(true);
                            return;
                        }
                    }
                }
            });
        }

        for (JButton button : deckSettingsButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
                    JTextField editDeckTextField = new JTextField("", TEXT_FIELD_LENGTH);

                    renameDeck.add(prompt);
                    renameDeck.add(editDeckTextField);
                    renameDeck.add(renameButton);

                    JButton deleteButton = new JButton("Delete Deck " + button.getName());
                    deleteDeck.add(deleteButton);

                    renameButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            editDeckController.edit(button.getName(), editDeckTextField.getText());
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

    private void clear() {
        this.removeAll();
        deckButtons.clear();
        deckSettingsButtons.clear();
    }
    private void customize() {
        this.setBackground(new Color(32, 32, 32));
    }

    private void customizeButtons(JButton backButton, JButton createDeckButton) {
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(88, 88, 88));

        createDeckButton.setForeground(Color.white);
        createDeckButton.setBackground(new Color(88, 88, 88));
    }
    private void addButtons(JButton backButton, JButton createDeckButton) {
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 1, 1, 0, 0, 0, 0);
        this.add(backButton, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.gridx = 1;
        this.add(createDeckButton, gridBagConstraints);
    }

    private void customizeSquashPanel(JPanel squashPanel) {
        squashPanel.setBackground(new Color(32, 32, 32));
    }

    private void addSquashPanel(JPanel squashPanel) {
        setConstraints(GridBagConstraints.CENTER, GridBagConstraints.BOTH, 2, 1, 0, deckNames.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);
    }

    private void loopSetUp() {
        gridBagConstraints.weighty = 0;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
    }

    private void addDeckButtons() {
        for (String name : deckNames) {
            JButton deckButton = new JButton(name);
            JButton deckSettingsButton = new JButton("...");
            initializeDeckButtons(name, deckButton, deckSettingsButton);
        }
    }

    private void initializeDeckButtons(String name, JButton deckButton, JButton deckSettingsButton) {
        // Customize Buttons
        deckButton.setForeground(Color.white);
        deckButton.setBackground(new Color(88, 88, 88));

        deckSettingsButton.setPreferredSize(new Dimension(30, 20));
        deckSettingsButton.setForeground(Color.white);
        deckSettingsButton.setBackground(new Color(88, 88, 88));
        deckSettingsButton.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 20), 1));

        // Store the buttons in class variable
        deckSettingsButton.setName(name);
        deckButtons.add(deckButton);
        deckSettingsButtons.add(deckSettingsButton);

        // Go to next line
        gridBagConstraints.gridy += 1;

        // Add the Settings button on the Deck Button
        deckButton.setLayout(new BorderLayout());
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(deckButton, gridBagConstraints);
        deckButton.add(deckSettingsButton, BorderLayout.EAST);
    }
    private void updateScreen() {
        this.revalidate();
        this.repaint();
    }
}
