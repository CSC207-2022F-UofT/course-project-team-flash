import screens.*;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    public static void main(String[] args) {
        // Build the Jframes
        JFrame application = new JFrame("Flashcard");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        DeckScreen deckScreen = new DeckScreen();
        QuizScreen quizScreen = new QuizScreen();

        screens.add(deckScreen);
        screens.add(quizScreen);
        application.setVisible(true);
        application.setSize(WIDTH, HEIGHT);
        // Call what needs to be called

        // IDK what else needs to be done
    }
}
