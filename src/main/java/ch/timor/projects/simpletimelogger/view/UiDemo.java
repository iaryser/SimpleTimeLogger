package ch.timor.projects.simpletimelogger.view;

import java.awt.*;

public class UiDemo {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.showCard(CardName.TIMETRACKER);
        mainFrame.setVisible(true);
    }
}
