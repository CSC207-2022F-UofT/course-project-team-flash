package screens;

import createDeck.CreateDeckController;
import createQuiz.CreateQuizController;
import deleteDeck.DeleteDeckController;
import deleteQuiz.DeleteQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class QuizScreen extends JPanel {

    // Controllers required by this Jpanel
    private CreateQuizController createQuizController;
    private DeleteQuizController deleteQuizController;

    // Decks
    private ArrayList<String> deckNames;

    // Quizzes
    private ArrayList<String> quizNames;

    private ArrayList<JButton> quizButtons;

    private ArrayList<JButton> quizSettingsButtons;

    // Interface Formatters
    private static final int TEXT_FIELD_LENGTH = 10;

    GridBagConstraints gridBagConstraints;

    public QuizScreen(CreateQuizController createQuizController, DeleteQuizController deleteQuizController) {
        super(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();
        this.deckNames = new ArrayList<>();
        this.quizNames = new ArrayList<>();
        this.quizButtons = new ArrayList<>();
        this.quizSettingsButtons = new ArrayList<>();
        this.createQuizController = createQuizController;
        this.deleteQuizController = deleteQuizController;
        drawComponents();
    }

    public void setController(CreateQuizController createQuizController, DeleteQuizController deleteQuizController) {
        this.createQuizController = createQuizController;
        this.deleteQuizController = deleteQuizController;
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

    private void drawComponents() {
        // creates/recreates the components of the Jpanel
        this.removeAll();
        quizButtons.clear();
        quizSettingsButtons.clear();
        JButton backButton = new JButton("Back");
        JButton quizCreationButton = new JButton("New Quiz");
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 1, 1, 0, 0, 0, 0);
        this.add(backButton, gridBagConstraints);
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.gridx = 1;
        this.add(quizCreationButton, gridBagConstraints);

        // The "squashPanel" for squashing components flush to the top
        JPanel squashPanel = new JPanel(new GridBagLayout());
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 2, 1, 0, quizNames.size() + 2, 1, 1);
        this.add(squashPanel, gridBagConstraints);

        // Pre for loop setup (for listing decks)
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        for (String name : quizNames) {
            JButton deckButton = new JButton(name);
            JButton deckSettingsButton = new JButton("...");
            deckSettingsButton.setName(name);
            quizButtons.add(deckButton);
            quizSettingsButtons.add(deckSettingsButton);

            gridBagConstraints.gridy += 1;
            deckButton.setLayout(new BorderLayout());
            gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
            this.add(deckButton, gridBagConstraints);
            deckButton.add(deckSettingsButton, BorderLayout.EAST);
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
        quizCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { chooseQuizCreation(); }
        });

        for (JButton button : quizButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //setVisible(false);
                    for (Component c : getParent().getComponents()) {
                        //if (c instanceof CardScreen) {
                        //    c.setVisible(true);
                        //    return;
                        //}
                    }
                }
            });
        }

        for (JButton button : quizSettingsButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame deckSettingsFrame = new JFrame();
                    JDialog newDeckDialog = new JDialog(deckSettingsFrame);

                    JTabbedPane optionTabs = new JTabbedPane();

                    JPanel renameQuiz = new JPanel();
                    JPanel deleteQuiz = new JPanel();

                    optionTabs.add("Rename Quiz", renameQuiz);
                    optionTabs.add("Delete Quiz", deleteQuiz);

                    newDeckDialog.add(optionTabs);

                    JLabel prompt = new JLabel("Enter a new name for the quiz:");
                    JTextField createDeckTextField = new JTextField("", TEXT_FIELD_LENGTH);
                    JButton renameButton = new JButton("Rename Quiz");
                    renameQuiz.add(prompt);
                    renameQuiz.add(createDeckTextField);
                    renameQuiz.add(renameButton);

                    JButton deleteButton = new JButton("Delete Quiz " + button.getName());
                    deleteQuiz.add(deleteButton);

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
                            deleteQuizController.deleteQuiz(button.getName());
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
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 1, 1, 0, 0, 0, 0);
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
        setConstraints(GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, 3, 1, 0, 2, 1, 1);
        createNewQuiz.add(squashPanel, gridBagConstraints);

        ArrayList<String> selectedDeckNames = new ArrayList<String>();

        for (String name : deckNames) {
            JCheckBox box = new JCheckBox(name);
            squashPanel.add(box);
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        selectedDeckNames.add(box.getText());
                    } else {
                        selectedDeckNames.remove(box.getText());
                    }
                }
            });
        }

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createQuizController.createQuiz(createQuizTextField.getText(), selectedDeckNames);
                newQuizFrame.dispose();
            }
        });

        newQuizDialog.pack();
        newQuizDialog.setModal(true);
        newQuizDialog.setVisible(true);


    }
}
