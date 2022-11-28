package screens;

import createCard.CreateCardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class CardScreen extends JPanel {
    // Controllers
    private CreateCardController createCardController;

    // Card Info
    private ArrayList<String[]> allCardsInfo;

    // Card Buttons
    private ArrayList<JButton> cardButtons;
    private ArrayList<JButton> cardSettingsButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;

    private GridBagConstraints gridBagConstraints;

    public CardScreen(CreateCardController createCardController) {
        super(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();
        this.createCardController = createCardController;
        this.cardSettingsButtons = new ArrayList<>();
        this.allCardsInfo = new ArrayList<>();
        this.cardButtons = new ArrayList<>();
        drawComponents();
    }

    public void setCreateCardController(CreateCardController createCardController) {
        this.createCardController = createCardController;
    }
    public void reconstructCards(boolean delete, String[] cardInfo) {
        if (delete) {
            allCardsInfo.remove(cardInfo);
        } else {
            allCardsInfo.add(cardInfo);
        }
        drawComponents();
    }

    private void drawComponents() {
        clear();

        JButton backButton = new JButton("Back");
        JButton cardCreationButton = new JButton("New Card");

        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 1, 1, 0, 0, 0, 0);
        this.add(backButton, gridBagConstraints);
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.gridx = 1;
        this.add(cardCreationButton, gridBagConstraints);
        createPanel();

        JPanel squashPanel = new JPanel(new GridBagLayout());
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 2, 1, 0, allCardsInfo.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);

        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        for (String[] cardInfo : allCardsInfo) {
            displayCard(cardInfo);
        }

        this.revalidate();
        this.repaint();

        backButton.addActionListener(new ActionListener() {
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

        cardCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseCardCreation();
            }
        });
    }
    private void clear() {
        this.removeAll();
        cardButtons.clear();
        cardSettingsButtons.clear();
    }
    private void setConstraints(int anchor, int fill, int gridWidth, int gridHeight, int gridX, int gridY, double weightX, double weightY) {
        this.gridBagConstraints.anchor = anchor;
        this.gridBagConstraints.fill = fill;
        this.gridBagConstraints.gridwidth = gridWidth;
        this.gridBagConstraints.gridheight = gridHeight;
        this.gridBagConstraints.gridx = gridX;
        this.gridBagConstraints.gridy = gridY;
        this.gridBagConstraints.weightx = weightX;
        this.gridBagConstraints.weighty = weightY;
    }

    private void createPanel() {
        JPanel squashPanel = new JPanel(new GridBagLayout());
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 2, 1, 0, allCardsInfo.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);
    }

    private void displayCard(String[] info) {
        String type = info[0];
        String question = info[1];
        String answer = info[2];

        // TODO: IDK HOW TO DO THIS
    }

    private void chooseCardCreation() {
        JFrame newDeckFrame = new JFrame();
        JDialog newDeckDialog = new JDialog(newDeckFrame);

        JTabbedPane optionTabs = new JTabbedPane();

        JPanel createNewDeck = new JPanel();
        JPanel importNewDeck = new JPanel();

        optionTabs.add("Create New Deck", createNewDeck);
        optionTabs.add("Import Deck", importNewDeck);
    }
}