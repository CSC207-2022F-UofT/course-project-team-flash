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

    private static final int TEXT_FIELD_LENGTH = 10;

    public ShowAnswerScreen(RunQuizController runQuizController) {
        super(new FlowLayout());
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

        JButton nextProblemButton = new JButton("Next Problem");
        JLabel cardAnswerLabel = new JLabel("Correct Answer: " + cardAnswer);
        JLabel userAnswerLabel = new JLabel("Your Answer: " + userAnswer);

        customize(nextProblemButton, cardAnswerLabel, userAnswerLabel);

        //setConstraints(

        this.add(cardAnswerLabel);
        this.add(userAnswerLabel);
        this.add(nextProblemButton);
        //other gridbag stuff:

        //

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
    private void customize(JButton nextProblemButton, JLabel cardAnswerLabel, JLabel userAnswerLabel) {
        this.setBackground(new Color(32, 32, 32));

        nextProblemButton.setForeground(Color.white);
        nextProblemButton.setBackground(new Color(88, 88, 88));

        cardAnswerLabel.setForeground(Color.white);
        cardAnswerLabel.setBackground(new Color(32, 32, 32));

        userAnswerLabel.setForeground(Color.white);
        userAnswerLabel.setBackground(new Color(32, 32, 32));
    }
}
