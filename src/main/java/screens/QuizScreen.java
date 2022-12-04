package screens;

import createQuiz.CreateQuizController;
import deleteQuiz.DeleteQuizController;
import editQuiz.EditQuizController;
import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class QuizScreen extends JPanel {

    // Controllers required by this Jpanel
    private CreateQuizController createQuizController;
    private DeleteQuizController deleteQuizController;
    private EditQuizController editQuizController;

    private RunQuizController runQuizController;

    // Decks
    private final ArrayList<String> deckNames;

    // Quizzes
    private final ArrayList<String> quizNames;

    private final ArrayList<JButton> quizButtons;

    private final ArrayList<JButton> quizSettingsButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;

    private final GridBagConstraints gridBagConstraints;

    public QuizScreen(CreateQuizController createQuizController, DeleteQuizController deleteQuizController,
                      EditQuizController editQuizController, RunQuizController runQuizController) {
        super(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();
        this.deckNames = new ArrayList<>();
        this.quizNames = new ArrayList<>();
        this.quizButtons = new ArrayList<>();
        this.quizSettingsButtons = new ArrayList<>();

        this.createQuizController = createQuizController;
        this.deleteQuizController = deleteQuizController;
        this.editQuizController = editQuizController;
        this.runQuizController = runQuizController;

        drawComponents();
    }

    public void setController(CreateQuizController createQuizController, DeleteQuizController deleteQuizController,
                              EditQuizController editQuizController, RunQuizController runQuizController) {
        this.createQuizController = createQuizController;
        this.deleteQuizController = deleteQuizController;
        this.editQuizController = editQuizController;
        this.runQuizController = runQuizController;
    }

    public void reconstructQuizzes(boolean delete, String quizName) {
        if (delete) {
            quizNames.remove(quizName);
        } else {
            quizNames.add(quizName);
        }
        drawComponents();
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

    private void drawComponents() {
        // creates/recreates the components of the Jpanel
        clear();
        customize();

        JButton backButton = new JButton("Back");
        JButton quizCreationButton = new JButton("New Quiz");
        customizeButtons(backButton, quizCreationButton);
        addButtons(backButton, quizCreationButton);

        // The "squashPanel" for squashing components flush to the top
        JPanel squashPanel = new JPanel(new GridBagLayout());
        customizeSquashPanel(squashPanel);
        addSquashPanel(squashPanel);

        // Pre for loop setup (for listing decks)
        loopSetUp();
        addQuizButtons();

        // re-renders the screen with new components
        updateScreen();

        backButton.addActionListener(e -> {
            setVisible(false);
            for (Component c : getParent().getComponents()) {
                if (c instanceof MainMenuScreen) {
                    c.setVisible(true);
                    return;
                }
            }
        });
        quizCreationButton.addActionListener(e -> chooseQuizCreation());

        for (JButton button : quizButtons) {
            button.addActionListener(e -> {
                JFrame startQuizFrame = new JFrame();
                JDialog startQuizDialog = new JDialog(startQuizFrame);
                JPanel startQuiz = new JPanel();
                startQuizDialog.add(startQuiz);

                JLabel startPrompt = new JLabel("Start quiz " + button.getText() + "?");
                JCheckBox randomCheckBox = new JCheckBox("Randomized order?", false);
                JButton startQuizButton = new JButton("Start");
                startQuiz.add(startPrompt);
                startQuiz.add(randomCheckBox);
                startQuiz.add(startQuizButton);

                startQuizButton.addActionListener(e1 -> {
                    runQuizController.startQuiz(button.getText(), randomCheckBox.isSelected());
                    startQuizFrame.dispose();
                });

                startQuizDialog.pack();
                startQuizDialog.setModal(true);
                startQuizDialog.setVisible(true);
            });
        }

        for (JButton button : quizSettingsButtons) {
            button.addActionListener(e -> {
                JFrame quizSettingsFrame = new JFrame();
                JDialog newQuizDialog = new JDialog(quizSettingsFrame);

                JTabbedPane optionTabs = new JTabbedPane();

                JPanel renameQuiz = new JPanel();
                JPanel deleteQuiz = new JPanel();

                optionTabs.add("Rename Quiz", renameQuiz);
                optionTabs.add("Delete Quiz", deleteQuiz);

                newQuizDialog.add(optionTabs);

                JLabel prompt = new JLabel("Enter a new name for the quiz:");
                JTextField editQuizTextField = new JTextField("", TEXT_FIELD_LENGTH);
                JButton renameButton = new JButton("Rename Quiz");

                renameQuiz.add(prompt);
                renameQuiz.add(editQuizTextField);
                renameQuiz.add(renameButton);

                JButton deleteButton = new JButton("Delete Quiz " + button.getName());
                deleteQuiz.add(deleteButton);

                renameButton.addActionListener(e12 -> {
                    editQuizController.edit(button.getName(), editQuizTextField.getText());
                    quizSettingsFrame.dispose();
                });

                deleteButton.addActionListener(e13 -> {
                    deleteQuizController.deleteQuiz(button.getName());
                    quizSettingsFrame.dispose();
                });

                newQuizDialog.pack();
                newQuizDialog.setModal(true);
                newQuizDialog.setVisible(true);

            });
        }
    }

    private void chooseQuizCreation() {
        JFrame newQuizFrame = new JFrame();
        JDialog newQuizDialog = new JDialog(newQuizFrame);

        JTabbedPane optionTabs = new JTabbedPane();

        JPanel createNewQuiz = new JPanel(new GridBagLayout());
        JPanel importNewQuiz = new JPanel();

        optionTabs.add("Create New Quiz", createNewQuiz);
        optionTabs.add("Import Quiz", importNewQuiz);

        newQuizDialog.add(optionTabs);

        JLabel prompt = new JLabel("Enter a name for the new quiz:");
        JLabel decksNote = new JLabel("Using decks:");
        JTextField createQuizTextField = new JTextField("", TEXT_FIELD_LENGTH);
        JButton createButton = new JButton("Create Quiz");
        setConstraints(GridBagConstraints.NONE, 1, 0, 0, 0);
        createNewQuiz.add(prompt, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        createNewQuiz.add(createQuizTextField, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        createNewQuiz.add(createButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        createNewQuiz.add(decksNote, gridBagConstraints);

        // The "squashPanel" for squashing components flush to the top
        JPanel squashPanel = new JPanel();
        setConstraints(GridBagConstraints.BOTH, 3, 2, 1, 1);
        createNewQuiz.add(squashPanel, gridBagConstraints);

        ArrayList<String> selectedDeckNames = new ArrayList<>();

        for (String name : deckNames) {
            JCheckBox box = new JCheckBox(name);
            squashPanel.add(box);
            box.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectedDeckNames.add(box.getText());
                } else {
                    selectedDeckNames.remove(box.getText());
                }
            });
        }

        createButton.addActionListener(e -> {
            createQuizController.createQuiz(createQuizTextField.getText(), selectedDeckNames);
            newQuizFrame.dispose();
        });

        newQuizDialog.pack();
        newQuizDialog.setModal(true);
        newQuizDialog.setVisible(true);
    }

    private void clear() {
        this.removeAll();
        quizButtons.clear();
        quizSettingsButtons.clear();
    }
    private void customize() {
        this.setBackground(new Color(32, 32, 32));
    }
    private void customizeButtons(JButton backButton, JButton quizCreationButton) {
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(88, 88, 88));

        quizCreationButton.setForeground(Color.white);
        quizCreationButton.setBackground(new Color(88, 88, 88));
    }
    private void addButtons(JButton backButton, JButton quizCreationButton) {
        setConstraints(GridBagConstraints.NONE, 1, 0, 0, 0);
        this.add(backButton, gridBagConstraints);

        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.gridx = 1;
        this.add(quizCreationButton, gridBagConstraints);
    }
    private void customizeSquashPanel(JPanel squashPanel) {
        squashPanel.setBackground(new Color(32, 32, 32));
    }
    private void addSquashPanel(JPanel squashPanel) {
        setConstraints(GridBagConstraints.BOTH, 2, quizNames.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);
    }
    private void loopSetUp() {
        gridBagConstraints.weighty = 0;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
    }
    private void addQuizButtons() {
        for (String name : quizNames) {
            JButton quizButton = new JButton(name);
            JButton quizSettingsButton = new JButton("...");
            initializeQuizButtons(name, quizButton, quizSettingsButton);
        }
    }
    private void initializeQuizButtons(String name, JButton quizButton, JButton quizSettingsButton) {
        // Customize Buttons
        quizButton.setForeground(Color.white);
        quizButton.setBackground(new Color(88, 88, 88));

        quizSettingsButton.setPreferredSize(new Dimension(30, 20));
        quizSettingsButton.setForeground(Color.white);
        quizSettingsButton.setBackground(new Color(88, 88, 88));
        quizSettingsButton.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 20), 1));

        // Store the buttons in class variable
        quizSettingsButton.setName(name);
        quizButtons.add(quizButton);
        quizSettingsButtons.add(quizSettingsButton);

        // Go to next line
        gridBagConstraints.gridy += 1;

        // Add the Settings button on the Deck Button
        quizButton.setLayout(new BorderLayout());
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(quizButton, gridBagConstraints);
        quizButton.add(quizSettingsButton, BorderLayout.EAST);
    }
    private void updateScreen() {
        this.revalidate();
        this.repaint();
    }
}
