package screens;

import createDeck.CreateDeckController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeckScreen extends JPanel implements ActionListener {
    public DeckScreen(){
        JLabel title = new JLabel("e");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
    }

    public void actionPerformed(ActionEvent evt){

    }
}
