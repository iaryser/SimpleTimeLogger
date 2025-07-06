package ch.timor.projects.simpletimelogger.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final CardLayout cards = new CardLayout();
    private final JPanel container = new JPanel(cards);

    public MainFrame(LoginPanel login, RegisterPanel register, TimeTrackerPanel timeTracker) {
        super("SimpleTimeLogger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        container.add(register, CardName.REGISTER.getCardName());
        container.add(login, CardName.LOGIN.getCardName());
        container.add(timeTracker, CardName.TIMETRACKER.getCardName());

        this.add(container, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void showCard(CardName cardName) {
        cards.show(container, cardName.getCardName());
    }
}
