package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizScreen extends JPanel implements ActionListener {
    public QuizScreen(){
        JButton backButton = new JButton("Back");
        this.add(backButton);
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

    }



    public void actionPerformed(ActionEvent evt){

    }
}
