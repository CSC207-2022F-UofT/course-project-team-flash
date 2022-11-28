package screens;

import createCard.CreateCardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class CardScreen extends JPanel {

    private CreateCardController createCardController;
    private ArrayList<String[]> allCardsInfo;
    private ArrayList<JButton> cardButtons;

    public CardScreen(CreateCardController createCardController) {
        this.createCardController = createCardController;
        this.allCardsInfo = new ArrayList<>();
        this.cardButtons = new ArrayList<>();
    }

    public void setCreateCardController(CreateCardController createCardController) {
        this.createCardController = createCardController;
    }

    public void reconstruct(boolean delete, String[] cardInfo) {
        if (delete) {
            allCardsInfo.remove(cardInfo);
        } else {
            allCardsInfo.add(cardInfo);
        }
        drawComponents();
    }

    private void drawComponents() {
        this.removeAll();

        JButton backButton = new JButton("Back");
        JButton cardCreationButton = new JButton("New Card");
        this.add(backButton);
        this.add(cardCreationButton);

        // TODO Need to create the card displays
        for (String[] card : allCardsInfo) {
        }
    }

}
