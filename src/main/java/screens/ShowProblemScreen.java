package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class ShowProblemScreen extends JPanel {

    private View view;

    private RunQuizController runQuizController;

    private String cardProblem;

    private String userAnswer;

    private static final int TEXT_FIELD_LENGTH = 10;

    private GridBagConstraints gridBagConstraints;

    public ShowProblemScreen(RunQuizController runQuizController){
        this.gridBagConstraints = new GridBagConstraints();
        this.runQuizController = runQuizController;
        this.cardProblem = "";
    }

    public void setController(RunQuizController runQuizController){
        this.runQuizController = runQuizController;
    }

    private void drawComponents(){
        this.removeAll();
        JButton showAnswerButton = new JButton("Show answer");
        JTextField userAnswerField = new JTextField();
        JLabel cardProblemDisplay = new JLabel(this.cardProblem);

        //setConstraints(

        this.add(showAnswerButton, gridBagConstraints);
        //other gridbag stuff:

        //
        this.add(userAnswerField, gridBagConstraints);

        this.add(cardProblemDisplay, gridBagConstraints);

        this.revalidate();
        this.repaint();

        showAnswerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                view.setUserAnswer(userAnswerField.getText());

                setVisible(false);

                runQuizController.showAnswer(view.getCardIdArray(), view.getCurrCardIndex(), view.getUserAnswer());


            }
        });



    }


}
