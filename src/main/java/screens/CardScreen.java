package screens;

import createCard.CreateCardController;
import deleteCard.DeleteCardController;
import editCard.EditCardController;
import moveCard.MoveCardController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CardScreen extends JPanel {
    // Controllers
    private CreateCardController createCardController;
    private DeleteCardController deleteCardController;
    private EditCardController editCardController;
    private MoveCardController moveCardController;

    // Deck Info
    private String deckName;

    // Card Info
    private final ArrayList<String[]> allCardsInfo;

    // Card Buttons
    private final ArrayList<JButton> cardButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;
    private final GridBagConstraints gridBagConstraints;

    public CardScreen(CreateCardController createCardController, DeleteCardController deleteCardController,
                      EditCardController editCardController, MoveCardController moveCardController) {
        super(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();

        this.createCardController = createCardController;
        this.deleteCardController = deleteCardController;
        this.editCardController = editCardController;
        this.moveCardController = moveCardController;
        this.allCardsInfo = new ArrayList<>();
        this.cardButtons = new ArrayList<>();

        drawComponents();
    }

    public void setController(CreateCardController createCardController, DeleteCardController deleteCardController,
                              EditCardController editCardController) {
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
        customize();

        JButton backButton = new JButton("Back");
        JButton cardCreationButton = new JButton("New Card");
        customizeButtons(backButton, cardCreationButton);
        addButtons(backButton, cardCreationButton);

        JPanel squashPanel = new JPanel(new GridBagLayout());
        customizePanel(squashPanel);
        addPanel(squashPanel);

        loopSetUp();
        for (String[] cardInfo : allCardsInfo) {
            displayCard(cardInfo);
        }
        updateScreen();

        backButton.addActionListener(e -> {
            setVisible(false);
            for (Component c : getParent().getComponents()) {
                if (c instanceof DeckScreen) {
                    c.setVisible(true);
                    return;
                }
            }
        });

        cardCreationButton.addActionListener(e -> chooseCardCreation());

        for (JButton button : cardButtons) {
            button.addActionListener(e -> {
                JFrame cardSettingsFrame = new JFrame();
                JDialog newCardDialog = new JDialog(cardSettingsFrame);

                JTabbedPane optionTabs = new JTabbedPane();

                JPanel editCard = new JPanel();
                JPanel deleteCard = new JPanel();
//                JPanel moveCard = new JPanel();

                optionTabs.add("Edit Card", editCard);
                optionTabs.add("Delete Card", deleteCard);
//                optionTabs.add("Move Card", moveCard);

                newCardDialog.add(optionTabs);

                JLabel dummyPrompt = new JLabel("Enter Additional Options:");
                JTextField dummy1TextField = new JTextField("", TEXT_FIELD_LENGTH);
                JTextField dummy2TextField = new JTextField("", TEXT_FIELD_LENGTH);
                JTextField dummy3TextField = new JTextField("", TEXT_FIELD_LENGTH);

                JLabel questionPrompt = new JLabel("Enter a new question for the card:");
                JTextField cardQuestionTextField = new JTextField("", TEXT_FIELD_LENGTH);
                JLabel answerPrompt = new JLabel("Enter a new answer for the card:");
                JTextField cardAnswerTextField = new JTextField("", TEXT_FIELD_LENGTH);
                JButton editButton = new JButton("Edit Card");

                if (Objects.equals(((JLabel) button.getComponent(1)).getText(), "MCFlashcard")) {
                    editCardAddMC(editCard, questionPrompt, cardQuestionTextField, answerPrompt, cardAnswerTextField,
                            dummyPrompt, dummy1TextField, dummy2TextField, dummy3TextField);
                } else {
                    editCardAddQnA(editCard, questionPrompt, cardQuestionTextField, answerPrompt, cardAnswerTextField);
                }

                editCard.add(editButton);

                editButton.addActionListener(e1 -> {
                    if (Objects.equals(((JLabel) button.getComponent(1)).getText(), "MCFlashcard")) {
                        List<String> dummyAnswers = Arrays.asList(dummy1TextField.getText(), dummy2TextField.getText(), dummy3TextField.getText());
                        editCardController.edit(button.getName(), cardQuestionTextField.getText(), cardAnswerTextField.getText(), dummyAnswers);
                    } else {
                        editCardController.edit(button.getName(), cardQuestionTextField.getText(), cardAnswerTextField.getText());
                    }
                    cardSettingsFrame.dispose();
                });

//                JLabel movePrompt = new JLabel("Enter the deck to move the card in:");
//                JTextField moveTextField = new JTextField("", TEXT_FIELD_LENGTH);
//                JButton moveButton = new JButton("Move Card");
//                moveCardAdd(moveCard, movePrompt, moveTextField, moveButton);
//
//                moveButton.addActionListener(e13 -> {
//                    System.out.println(deckName);
//                    System.out.println(moveTextField.getText());
//                    System.out.println(button.getName());
//                    moveCardController.move(deckName, moveTextField.getText(), button.getName());
//                    cardSettingsFrame.dispose();
//                });

                JButton deleteButton = new JButton("Delete Card");
                deleteCard.add(deleteButton);

                deleteButton.addActionListener(e12 -> {
                    deleteCardController.delete(button.getName(), deckName);
                    cardSettingsFrame.dispose();
                });

                newCardDialog.pack();
                newCardDialog.setLocationRelativeTo(null);
                newCardDialog.setModal(true);
                newCardDialog.setVisible(true);
            });
        }
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
        JLabel dummyPrompt = new JLabel("Enter Options:");

        JTextField questionQnATextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField answerQnATextField = new JTextField("", TEXT_FIELD_LENGTH);

        JTextField questionMCTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField answerMCTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy1TextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy2TextField = new JTextField("", TEXT_FIELD_LENGTH);
        JTextField dummy3TextField = new JTextField("", TEXT_FIELD_LENGTH);

        JButton createQnAButton = new JButton("Create Card");
        JButton createMCButton = new JButton("Create Card");

        addToQnA(createQnACard, questionQnAPrompt, questionQnATextField, answerQnAPrompt, answerQnATextField, createQnAButton);
        addToMC(createMCCard, questionMCPrompt, questionMCTextField, answerMCPrompt, answerMCTextField, dummyPrompt,
                dummy1TextField, dummy2TextField, dummy3TextField, createMCButton);

        createQnAButton.addActionListener(e -> {
            createCardController.create(deckName, questionQnATextField.getText(), answerQnATextField.getText());
            newCardFrame.dispose();
        });

        createMCButton.addActionListener(e -> {
            List<String> dummyAnswers = Arrays.asList(dummy1TextField.getText(), dummy2TextField.getText(), dummy3TextField.getText());
            createCardController.create(deckName, questionMCTextField.getText(), answerMCTextField.getText(), dummyAnswers);
            newCardFrame.dispose();
        });

        newCardDialog.pack();
        newCardDialog.setModal(true);
        newCardDialog.setVisible(true);
    }
    private void clear() {
        this.removeAll();
        cardButtons.clear();
    }
    private void customize() {
        this.setBackground(new Color(32, 32, 32));
    }
    private void setConstraints(int fill, int gridWidth, int gridY, double weightX, double weightY) {
        this.gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.gridBagConstraints.fill = fill;
        this.gridBagConstraints.gridwidth = gridWidth;
        this.gridBagConstraints.gridheight = 1;
        this.gridBagConstraints.gridx = 0;
        this.gridBagConstraints.gridy = gridY;
        this.gridBagConstraints.weightx = weightX;
        this.gridBagConstraints.weighty = weightY;
    }
    private void customizeButtons(JButton backButton, JButton cardCreationButton) {
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(88, 88, 88));

        cardCreationButton.setForeground(Color.white);
        cardCreationButton.setBackground(new Color(88, 88, 88));
    }

    private void addButtons(JButton backButton, JButton cardCreationButton) {
        setConstraints(GridBagConstraints.NONE, 1, 0, 0, 0);
        this.add(backButton, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.gridx = 1;
        this.add(cardCreationButton, gridBagConstraints);
    }
    private void customizePanel(JPanel squashPanel) {
        squashPanel.setBackground(new Color(32, 32, 32));
    }
    private void addPanel(JPanel squashPanel) {
        setConstraints(GridBagConstraints.BOTH, 2, allCardsInfo.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);
    }
    private void loopSetUp() {
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
    }
    private void displayCard(String[] info) {
        String type = info[0];
        String question = info[1];
        String answer = info[2];
        String id = info[3];

        JButton cardButton = new JButton(answer);
        JLabel questionLabel = new JLabel(question);
        JLabel typeLabel = new JLabel(type);

        initializeCardButtons(id, cardButton, questionLabel, typeLabel);
    }
    private void updateScreen() {
        this.revalidate();
        this.repaint();
    }
    private void editCardAddQnA(JPanel editCard, JLabel questionPrompt, JTextField cardQuestionTextField,
                               JLabel answerPrompt, JTextField cardAnswerTextField) {
        editCard.add(questionPrompt);
        editCard.add(cardQuestionTextField);
        editCard.add(answerPrompt);
        editCard.add(cardAnswerTextField);
    }
    private void editCardAddMC(JPanel editCard, JLabel questionPrompt, JTextField questionTextField,
                               JLabel answerPrompt, JTextField answerTextField, JLabel dummyPrompt,
                               JTextField dummy1TextField, JTextField dummy2TextField, JTextField dummy3TextField) {
        editCard.add(questionPrompt);
        editCard.add(questionTextField);
        editCard.add(answerPrompt);
        editCard.add(answerTextField);
        editCard.add(dummyPrompt);
        editCard.add(dummy1TextField);
        editCard.add(dummy2TextField);
        editCard.add(dummy3TextField);
    }
    private void addToQnA(JPanel createQnACard, JLabel questionQnAPrompt, JTextField questionQnATextField,
                          JLabel answerQnAPrompt, JTextField answerQnATextField, JButton createQnAButton) {
        createQnACard.add(questionQnAPrompt);
        createQnACard.add(questionQnATextField);
        createQnACard.add(answerQnAPrompt);
        createQnACard.add(answerQnATextField);
        createQnACard.add(createQnAButton);
    }

    private void addToMC(JPanel createMCCard, JLabel questionMCPrompt, JTextField questionMCTextField,
                         JLabel answerMCPrompt, JTextField answerMCTextField, JLabel dummyPrompt,
                         JTextField dummy1TextField, JTextField dummy2TextField, JTextField dummy3TextField,
                         JButton createMCButton) {
        createMCCard.add(questionMCPrompt);
        createMCCard.add(questionMCTextField);
        createMCCard.add(answerMCPrompt);
        createMCCard.add(answerMCTextField);
        createMCCard.add(dummyPrompt);
        createMCCard.add(dummy1TextField);
        createMCCard.add(dummy2TextField);
        createMCCard.add(dummy3TextField);
        createMCCard.add(createMCButton);
    }

//    private void moveCardAdd(JPanel moveCard, JLabel movePrompt, JTextField moveTextField, JButton moveButton) {
//        moveCard.add(movePrompt);
//        moveCard.add(moveTextField);
//        moveCard.add(moveButton);
//    }

    private void initializeCardButtons(String name, JButton cardButton,
                                       JLabel questionLabel, JLabel typeLabel) {
        cardButton.setName(name);
        cardButton.setForeground(Color.white);
        cardButton.setBackground(new Color(88, 88, 88));

        questionLabel.setForeground(Color.white);

        cardButtons.add(cardButton);
        cardButton.setLayout(new BorderLayout());

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cardButton, gridBagConstraints);

        cardButton.add(questionLabel, BorderLayout.WEST);
        cardButton.add(typeLabel, BorderLayout.EAST);
        gridBagConstraints.gridy += 1;
    }
}