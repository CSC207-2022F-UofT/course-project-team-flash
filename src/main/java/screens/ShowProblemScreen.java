package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
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
        JLabel cardProblemLabel = new JLabel(this.cardProblem);

        customize(showAnswerButton, userAnswerField, cardProblemLabel);

        if(this.cardOptions != null) {
            JLabel option1 = new JLabel(this.cardOptions.get(0));
            JLabel option2 = new JLabel(this.cardOptions.get(1));
            JLabel option3 = new JLabel(this.cardOptions.get(2));
            JLabel answer = new JLabel(this.cardAnswer);

            this.add(cardProblemLabel);
            this.add(option1);
            this.add(option2);
            this.add(option3);
            this.add(answer);
            this.add(userAnswerField);
            this.add(showAnswerButton);
        }

        this.add(cardProblemLabel);
        this.add(userAnswerField);
        this.add(showAnswerButton);

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

}
