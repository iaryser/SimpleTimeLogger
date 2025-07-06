package ch.timor.projects.simpletimelogger;

import ch.timor.projects.simpletimelogger.controller.AppController;
import ch.timor.projects.simpletimelogger.model.LoginService;
import ch.timor.projects.simpletimelogger.model.UserDataBase;
import ch.timor.projects.simpletimelogger.model.WorkSession;
import ch.timor.projects.simpletimelogger.view.MainFrame;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();

            UserDataBase userDb       = new UserDataBase();
            LoginService loginService = new LoginService(userDb);
            WorkSession workSession  = new WorkSession();

            new AppController(frame, userDb, loginService, workSession);

            frame.setVisible(true);
        });
    }
}
