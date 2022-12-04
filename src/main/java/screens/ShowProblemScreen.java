package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ShowProblemScreen extends JPanel {

    private RunQuizController runQuizController;

    private String[] cardIdArray;

    private int currCardIndex;

    private String cardProblem;

    private List<String> cardOptions;
    private static final int TEXT_FIELD_LENGTH = 10;

    public ShowProblemScreen(RunQuizController runQuizController) {
        super(new FlowLayout());
        this.runQuizController = runQuizController;
        this.cardProblem = "";
    }

    public void setQuiz(String[] cardIdArray, int currCardIndex, String question, List<String> cardOptions) {
        this.cardIdArray = cardIdArray;
        this.currCardIndex = currCardIndex;
        this.cardProblem = question;
        this.cardOptions = cardOptions;
        drawComponents();
    }

    public void setController(RunQuizController runQuizController) {
        this.runQuizController = runQuizController;
    }

    private void drawComponents() {
        this.removeAll();
        JButton showAnswerButton = new JButton("Show answer");
        JTextField userAnswerField = new JTextField(TEXT_FIELD_LENGTH);
        JLabel cardProblemDisplay = new JLabel(this.cardProblem);

        if(this.cardOptions != null) {
            JList cardOptionsDisplay = new JList(this.cardOptions.toArray());
            this.add(cardOptionsDisplay);
        }
        //setConstraints(

        this.add(cardProblemDisplay);
        this.add(userAnswerField);
        this.add(showAnswerButton);

        //other gridbag stuff:

        //


        this.revalidate();
        this.repaint();

        showAnswerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);

                runQuizController.showAnswer(cardIdArray, currCardIndex, userAnswerField.getText());

            }
        });


    }


}
