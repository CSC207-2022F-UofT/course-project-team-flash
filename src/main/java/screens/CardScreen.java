package screens;

import createCard.CreateCardController;
import deleteCard.DeleteCardController;
import editCard.EditCardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;


public class CardScreen extends JPanel {
    // Controllers
    private CreateCardController createCardController;

    private DeleteCardController deleteCardController;

    private EditCardController editCardController;

    // Deck Info
    private String deckName;

    // Card Info
    private ArrayList<String[]> allCardsInfo;

    // Card Buttons
    private ArrayList<JButton> cardButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;

    private GridBagConstraints gridBagConstraints;

    public CardScreen(CreateCardController createCardController, DeleteCardController deleteCardController, EditCardController editCardController) {
        super(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();
        this.createCardController = createCardController;
        this.deleteCardController = deleteCardController;
        this.editCardController = editCardController;
        this.allCardsInfo = new ArrayList<>();
        this.cardButtons = new ArrayList<>();
        drawComponents();
    }

    public void setController(CreateCardController createCardController, DeleteCardController deleteCardController, EditCardController editCardController) {
        this.createCardController = createCardController;
        this.deleteCardController = deleteCardController;
        this.editCardController = editCardController;
    }
    public void reconstructCards(boolean delete, String[] cardInfo) {
        if (delete) {
            for (String[] oldInfo : allCardsInfo) {
                if (Objects.equals(oldInfo[3], cardInfo[3])) {
                    allCardsInfo.remove(oldInfo);
                    break;
                }
            }
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
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 2, 1, 0, allCardsInfo.size() + 1, 1, 1);
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

        for (JButton button : cardButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame cardSettingsFrame = new JFrame();
                    JDialog newCardDialog = new JDialog(cardSettingsFrame);

                    JTabbedPane optionTabs = new JTabbedPane();

                    JPanel editCard = new JPanel();
                    JPanel deleteCard = new JPanel();

                    optionTabs.add("Edit Card", editCard);
                    optionTabs.add("Delete Card", deleteCard);

                    newCardDialog.add(optionTabs);

                    JLabel questionPrompt = new JLabel("Enter a new question for the card:");
                    JTextField cardQuestionTextField = new JTextField("", TEXT_FIELD_LENGTH);
                    JLabel answerPrompt = new JLabel("Enter a new answer for the card:");
                    JTextField cardAnswerTextField = new JTextField("", TEXT_FIELD_LENGTH);
                    JButton editButton = new JButton("Edit Card");
                    editCard.add(questionPrompt);
                    editCard.add(cardQuestionTextField);
                    editCard.add(answerPrompt);
                    editCard.add(cardAnswerTextField);
                    editCard.add(editButton);

                    JButton deleteButton = new JButton("Delete Card");
                    deleteCard.add(deleteButton);

                    editButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            editCardController.edit(button.getName(), cardQuestionTextField.getText(), cardAnswerTextField.getText());
                            cardSettingsFrame.dispose();
                        }
                    });

                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteCardController.delete(button.getName(), deckName);
                            cardSettingsFrame.dispose();
                        }
                    });

                    newCardDialog.pack();
                    newCardDialog.setModal(true);
                    newCardDialog.setVisible(true);
                }
            });
        }
    }
    private void clear() {
        this.removeAll();
        cardButtons.clear();
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
        String id = info[3];

        JButton cardButton = new JButton(answer);
        cardButton.setName(id);
        JLabel questionLabel = new JLabel(question);
        JLabel typeLabel = new JLabel(type);
        cardButtons.add(cardButton);
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

        JLabel questionQnAPrompt = new JLabel("Enter a question:");
        JLabel answerQnAPrompt = new JLabel("Enter the answer:");
        JLabel questionMCPrompt = new JLabel("Enter a question:");
        JLabel answerMCPrompt = new JLabel("Enter the answer:");
        JLabel dummyPrompt = new JLabel("Enter dummy answers:");
        JTextField questionQnATextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField answerQnATextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField questionMCTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField answerMCTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy1TextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy2TextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy3TextField = new JTextField("", TEXT_FIELD_LENGTH);
        JButton createQnAButton = new JButton("Create Card");
        JButton createMCButton = new JButton("Create Card");

        createQnACard.add(questionQnAPrompt);
        createQnACard.add(questionQnATextField);
        createQnACard.add(answerQnAPrompt);
        createQnACard.add(answerQnATextField);
        createQnACard.add(createQnAButton);

        createMCCard.add(questionMCPrompt);
        createMCCard.add(questionMCTextField);
        createMCCard.add(answerMCPrompt);
        createMCCard.add(answerMCTextField);
        createMCCard.add(dummyPrompt);
        createMCCard.add(dummy1TextField);
        createMCCard.add(dummy2TextField);
        createMCCard.add(dummy3TextField);
        createMCCard.add(createMCButton);

        createQnAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCardController.create(deckName, questionQnATextField.getText(), answerQnATextField.getText());
                newCardFrame.dispose();
            }
        });

        createMCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> dummyAnswers = Arrays.asList(dummy1TextField.getText(), dummy2TextField.getText(), dummy3TextField.getText());;
                createCardController.create(deckName, questionMCTextField.getText(), answerMCTextField.getText(), dummyAnswers);
                newCardFrame.dispose();
            }
        });

        newCardDialog.pack();
        newCardDialog.setModal(true);
        newCardDialog.setVisible(true);


    }
}