import screens.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the Jframes
        JFrame application = new JFrame("Flashcard");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        DeckScreen deckScreen = new DeckScreen();
        screens.add(deckScreen, "pain");
        cardLayout.show(screens, "e");
        application.pack();
        application.setVisible(true);
        application.setSize(400, 300);
        // Call what needs to be called

        // IDK what else needs to be done
    }
}
