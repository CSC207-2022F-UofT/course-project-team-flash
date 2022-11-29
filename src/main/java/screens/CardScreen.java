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

    // Deck Info
    private String deckName;

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

    public void setController(CreateCardController createCardController) {
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

    public void reconstructCards() {
        drawComponents();
    }

    public void swapScreen() {
        allCardsInfo.clear();}

    public void setDeck(String deckName) {this.deckName = deckName;}

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

        JButton cardButton = new JButton(answer);
        JLabel questionLabel = new JLabel(question);
        JLabel typeLabel = new JLabel(type);
        cardButtons.add(cardButton);

        gridBagConstraints.gridy += 1;
        cardButton.setLayout(new BorderLayout());
        gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
        this.add(cardButton, gridBagConstraints);
        cardButton.add(questionLabel, BorderLayout.WEST);
        cardButton.add(typeLabel, BorderLayout.EAST);
        gridBagConstraints.gridy += 1;
    }

    private void chooseCardCreation() {
        JFrame newCardFrame = new JFrame();
        JDialog newCardDialog = new JDialog(newCardFrame);

        JTabbedPane optionTabs = new JTabbedPane();

        JPanel createQnACard = new JPanel();
        JPanel createMCCard = new JPanel();

        optionTabs.add("Create QnA Card", createQnACard);
        optionTabs.add("Create Multiple Choice Card", createMCCard);

        newCardDialog.add(optionTabs);

        JLabel questionPrompt = new JLabel("Enter a question:");
        JLabel answerPrompt = new JLabel("Enter the answer:");
        JTextField questionTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField answerTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JButton createButton = new JButton("Create Card");
        createQnACard.add(questionPrompt);
        createQnACard.add(questionTextField);
        createQnACard.add(answerPrompt);
        createQnACard.add(answerTextField);
        createQnACard.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCardController.create(deckName, 1, questionTextField.getText(), answerTextField.getText());
                newCardFrame.dispose();
            }
        });

        newCardDialog.pack();
        newCardDialog.setModal(true);
        newCardDialog.setVisible(true);


    }
}