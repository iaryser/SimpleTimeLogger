package ch.timor.projects.simpletimelogger.view;

import ch.timor.projects.simpletimelogger.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class MainFrame extends JFrame {

    private final CardLayout cards = new CardLayout();
    private final JPanel container = new JPanel(cards);
    private final LoginPanel loginPanel = new LoginPanel();
    private final RegisterPanel registerPanel = new RegisterPanel();
    private final TimeTrackerPanel timeTrackerPanel = new TimeTrackerPanel();

    public MainFrame() {
        super("Simple Time Logger");
        container.add(registerPanel, CardName.REGISTER.getCardName());
        container.add(loginPanel, CardName.LOGIN.getCardName());
        container.add(timeTrackerPanel, CardName.TIMETRACKER.getCardName());
        setContentPane(container);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.showLoginPanel();
    }

    public RegisterPanel getRegisterPanel() {
        return this.registerPanel;
    }

    public LoginPanel getLoginPanel() {
        return this.loginPanel;
    }

    public TimeTrackerPanel getTimeTrackerPanel() {
        return this.timeTrackerPanel;
    }

    public void showLoginPanel()    {
        cards.show(container, CardName.LOGIN.getCardName());
    }

    public void showRegisterPanel() {
        cards.show(container, CardName.REGISTER.getCardName());
    }
    public void showTrackerPanel()  {
        cards.show(container, CardName.TIMETRACKER.getCardName());
    }

    public void setActionListenerForAllPanels(ActionListener listener) {
        this.loginPanel.setActionListener(listener);
        this.registerPanel.setActionListener(listener);
        this.timeTrackerPanel.setActionListener(listener);
    }
}
