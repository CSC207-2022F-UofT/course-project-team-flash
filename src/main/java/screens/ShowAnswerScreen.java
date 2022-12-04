package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

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
        this.removeAll();
        JButton nextProblemButton = new JButton("Next Problem");
        JLabel cardAnswerLabel = new JLabel(cardAnswer);
        JLabel userAnswerLabel = new JLabel(userAnswer);
        //setConstraints(

        this.add(cardAnswerLabel);
        this.add(userAnswerLabel);
        this.add(nextProblemButton);
        //other gridbag stuff:

        //

        this.revalidate();
        this.repaint();

        nextProblemButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                runQuizController.showProblem(cardIdArray, currCardIndex);


            }
        });



    }


}
