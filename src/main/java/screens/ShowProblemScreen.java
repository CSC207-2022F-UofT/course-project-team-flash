package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowProblemScreen extends JPanel {

    private RunQuizController runQuizController;
    private String[] cardIdArray;
    private int currCardIndex;
    private String cardProblem;
    private String cardAnswer;
    private List<String> cardOptions;
    private static final int TEXT_FIELD_LENGTH = 10;

    public ShowProblemScreen(RunQuizController runQuizController) {
        this.runQuizController = runQuizController;
        this.cardProblem = "";
    }

    public void setQuiz(String[] cardIdArray, int currCardIndex, String question,
                        String answer, List<String> cardOptions) {
        this.cardIdArray = cardIdArray;
        this.currCardIndex = currCardIndex;
        this.cardProblem = question;
        this.cardAnswer = answer;
        this.cardOptions = cardOptions;
        drawComponents();
    }

    public void setController(RunQuizController runQuizController) {
        this.runQuizController = runQuizController;
    }

    private void drawComponents() {
        clear();
        setUp();

        JButton showAnswerButton = new JButton("Show answer");
        JTextField userAnswerField = new JTextField(TEXT_FIELD_LENGTH);
        JLabel cardProblemLabel = new JLabel("Question: " + this.cardProblem);
        JLabel option = new JLabel("Options:");

        customize(showAnswerButton, userAnswerField, cardProblemLabel);

        if(this.cardOptions != null) {
            JLabel option1 = new JLabel(this.cardOptions.get(0));
            JLabel option2 = new JLabel(this.cardOptions.get(1));
            JLabel option3 = new JLabel(this.cardOptions.get(2));
            JLabel answer = new JLabel(this.cardAnswer);

            customizeMC(option, option1, option2, option3, answer);

            this.add(cardProblemLabel);
            this.add(userAnswerField);

            ArrayList<JLabel> array = new ArrayList<>();
            addToArrayList(array, option1, option2, option3, answer);
            Collections.shuffle(array);
            addToPanel(array);

            this.add(showAnswerButton);

        } else {
            this.add(cardProblemLabel);
            this.add(userAnswerField);
            this.add(showAnswerButton);
        }
        this.revalidate();
        this.repaint();

        showAnswerButton.addActionListener(e -> {

            setVisible(false);
            runQuizController.showAnswer(cardIdArray, currCardIndex, userAnswerField.getText());

        });
    }

    private void clear() {
        this.removeAll();
    }
    private void setUp() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void customize(JButton showAnswerButton, JTextField userAnswerField, JLabel cardProblemLabel) {
        this.setBackground(new Color(32, 32, 32));

        cardProblemLabel.setBackground(new Color(32, 32, 32));
        cardProblemLabel.setForeground(Color.white);
        cardProblemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        userAnswerField.setMaximumSize(new Dimension(200, 20));
        userAnswerField.setAlignmentX(Component.CENTER_ALIGNMENT);

        showAnswerButton.setBackground(new Color(88, 88, 88));
        showAnswerButton.setForeground(Color.white);
        showAnswerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    private void customizeMC(JLabel option, JLabel option1, JLabel option2, JLabel option3, JLabel answer) {
        JLabel[] labels = {option, option1, option2, option3, answer};
        for (JLabel label : labels) {
            label.setForeground(Color.white);
            label.setBackground(new Color(32, 32, 32));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }
    private void addToArrayList(ArrayList<JLabel> array, JLabel option1,
                                JLabel option2, JLabel option3, JLabel answer) {
        array.add(option1);
        array.add(option2);
        array.add(option3);
        array.add(answer);
    }
    private void addToPanel(ArrayList<JLabel> array) {
        for (JLabel label : array) {
            this.add(label);
        }
    }
}
