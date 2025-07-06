package ch.timor.projects.simpletimelogger.view;

import java.awt.*;

public class UiDemo {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(new LoginPanel(), new RegisterPanel(), new TimeTrackerPanel());
        mainFrame.showCard(CardName.TIMETRACKER);
        mainFrame.setVisible(true);
    }
}
