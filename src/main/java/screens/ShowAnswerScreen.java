package screens;

import runQuiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class ShowAnswerScreen extends JPanel {

    private View view;

    private RunQuizController runQuizController;

    private String cardAnswer;

    private String userAnswer;

    private static final int TEXT_FIELD_LENGTH = 10;

    private GridBagConstraints gridBagConstraints;

    public ShowAnswerScreen(View view, RunQuizController runQuizController){
        this.view = view;
        this.gridBagConstraints = new GridBagConstraints();
        this.runQuizController = runQuizController;
        this.cardAnswer = view.getCardAnswer();
        this.userAnswer = view.getUserAnswer();
    }

    public void setController(RunQuizController runQuizController){
        this.runQuizController = runQuizController;
    }



    private void drawComponents(){
        this.removeAll();
        JButton showAnswerButton = new JButton("Next Problem");
        JTextField userAnswerField = new JTextField();

        //setConstraints(

        this.add(showAnswerButton, gridBagConstraints);
        //other gridbag stuff:

        //
        this.add(userAnswerField, gridBagConstraints);

        this.revalidate();
        this.repaint();

        showAnswerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                runQuizController.showProblem(view.getCardIdArray(), view.getCurrCardIndex());


            }
        });



    }


}
