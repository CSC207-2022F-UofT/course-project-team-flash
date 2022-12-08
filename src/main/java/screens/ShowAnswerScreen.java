package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;

public class ShowAnswerScreen extends JPanel {

    private RunQuizController runQuizController;

    private String[] cardIdArray;

    private int currCardIndex;

    private String cardAnswer;

    private String userAnswer;

    public ShowAnswerScreen(RunQuizController runQuizController) {
        this.runQuizController = runQuizController;
    }
    public void setQuiz(String[] cardIdArray, int currCardIndex, String cardAnswer, String userAnswer) {
        this.cardIdArray = cardIdArray;
        this.currCardIndex = currCardIndex;
        this.cardAnswer = cardAnswer;
        this.userAnswer = userAnswer;
        drawComponents();
    }

    public void setController(RunQuizController runQuizController){
        this.runQuizController = runQuizController;
    }

    private void drawComponents(){
        clear();
        setUp();

        JButton nextProblemButton = new JButton("Next Problem");
        JLabel cardAnswerLabel = new JLabel("Correct Answer: " + cardAnswer);
        JLabel userAnswerLabel = new JLabel("Your Answer: " + userAnswer);

        customize(nextProblemButton, cardAnswerLabel, userAnswerLabel);

        this.add(cardAnswerLabel);
        this.add(userAnswerLabel);
        this.add(nextProblemButton);

        this.revalidate();
        this.repaint();

        nextProblemButton.addActionListener(e -> {
            setVisible(false);
            runQuizController.showProblem(cardIdArray, currCardIndex);
        });
    }
    private void clear() {
        this.removeAll();
    }
    private void setUp() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void customize(JButton nextProblemButton, JLabel cardAnswerLabel, JLabel userAnswerLabel) {
        this.setBackground(new Color(32, 32, 32));

        nextProblemButton.setForeground(Color.white);
        nextProblemButton.setBackground(new Color(88, 88, 88));
        nextProblemButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cardAnswerLabel.setForeground(Color.white);
        cardAnswerLabel.setBackground(new Color(32, 32, 32));
        cardAnswerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        userAnswerLabel.setForeground(Color.white);
        userAnswerLabel.setBackground(new Color(32, 32, 32));
        userAnswerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
