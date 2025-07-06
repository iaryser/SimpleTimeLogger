package ch.timor.projects.simpletimelogger.controller;

import ch.timor.projects.simpletimelogger.model.*;
import ch.timor.projects.simpletimelogger.view.MainFrame;
import ch.timor.projects.simpletimelogger.view.TimeTrackerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.EventObject;

public class AppController
        implements ActionListener,
        LoginServiceListener,
        UserDataBaseListener,
        SessionListener {

    private final MainFrame   mainFrame;
    private final UserDataBase userDataBase;
    private final LoginService loginService;
    private final WorkSession  workSession;
    private Timer workTimer;
    private Timer pauseTimer;

    private Timer uiTimer;

    public AppController(MainFrame mainFrame,
                         UserDataBase userDataBase,
                         LoginService loginService,
                         WorkSession workSession) {
        this.mainFrame    = mainFrame;
        this.userDataBase = userDataBase;
        this.loginService = loginService;
        this.workSession  = workSession;


        this.mainFrame.setActionListenerForAllPanels(this);
        this.userDataBase.addUserDataBaseListener(this);
        this.loginService.addLoginServiceListener(this);
        this.workSession.addSessionListener(this);
    }

    //View-Events
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //LoginPanel
        if (src == mainFrame.getLoginPanel().getLoginButton()) {
            String user = mainFrame.getLoginPanel().getUserName();
            String pass = mainFrame.getLoginPanel().getPassword();
            loginService.login(user, pass);
            return;
        }
        if (src == mainFrame.getLoginPanel().getRegisterButton()) {
            mainFrame.showRegisterPanel();
            return;
        }

        //RegisterPanel
        if (src == mainFrame.getRegisterPanel().getSubmitButton()) {
            String first = mainFrame.getRegisterPanel().getFirstName();
            String last  = mainFrame.getRegisterPanel().getLastName();
            String user  = mainFrame.getRegisterPanel().getUserName();
            String pass  = mainFrame.getRegisterPanel().getPassword();
            userDataBase.addUser(new User(first, last, user, pass));
            return;
        }

        //TimeTrackerPanel
        TimeTrackerPanel tracker = mainFrame.getTimeTrackerPanel();
        if (src == tracker.getStartWorkButton()) {
            workSession.startWorking();
            return;
        }
        if (src == tracker.getStartPauseButton()) {
            workSession.pauseWorking();    // falls du eine Pause()-Methode hast
            return;
        }
        if (src == tracker.getQuitButton()) {
            System.exit(0);
        }
    }

    //LoginServiceListener
    @Override
    public void handleLoginEvent(EventObject event) {
        if (event instanceof LoginSuccessEvent) {
            mainFrame.showTrackerPanel();
        }
        else if (event instanceof LoginFailureEvent) {
            mainFrame.getLoginPanel().loginFailure("Benutzername oder passwort nicht korrekt.");
        }
        else if (event instanceof LoginNoUserFoundEvent) {
            mainFrame.showRegisterPanel();
        }
    }

    //UserDataBaseListener
    @Override
    public void handleRegisterEvent(EventObject event) {
        SwingUtilities.invokeLater(() -> {
            mainFrame.showLoginPanel();
            mainFrame.getLoginPanel().loginFailure("Registrierung erfolgreich – bitte einloggen.");
        });
    }

    //SessionListener
    @Override
    public void handleSessionEvent(EventObject event) {
        if (event instanceof SessionStartedEvent) {
            if (pauseTimer != null) pauseTimer.stop();
            if (workTimer != null) workTimer.stop();
            workTimer = new Timer(1000, ev -> {
                String work = formatDuration(workSession.getCurrentWorkDuration());
                mainFrame.getTimeTrackerPanel().setWorkTime(work);
            });
            workTimer.start();
        }

        else if (event instanceof SessionPausedEvent) {
            if (workTimer != null) workTimer.stop();
            if (pauseTimer != null) pauseTimer.stop();
            pauseTimer = new Timer(1000, ev -> {
                String pause = formatDuration(workSession.getCurrentPauseDuration());
                mainFrame.getTimeTrackerPanel().setPauseTime(pause);
            });
            pauseTimer.start();

            SessionPausedEvent pe = (SessionPausedEvent) event;
            mainFrame.getTimeTrackerPanel().setWorkTime(
                    formatDuration(pe.getTotalWork())
            );
        }

        else if (event instanceof SessionResumedEvent) {
            if (pauseTimer != null) pauseTimer.stop();
            if (workTimer != null) workTimer.stop();
            workTimer = new Timer(1000, ev -> {
                String work = formatDuration(workSession.getCurrentWorkDuration());
                mainFrame.getTimeTrackerPanel().setWorkTime(work);
            });
            workTimer.start();

            SessionResumedEvent re = (SessionResumedEvent) event;
            mainFrame.getTimeTrackerPanel().setPauseTime(
                    formatDuration(re.getTotalPause())
            );
        }

        else if (event instanceof SessionResetEvent) {
            if (workTimer  != null) workTimer.stop();
            if (pauseTimer != null) pauseTimer.stop();
            mainFrame.getTimeTrackerPanel().setWorkTime("00:00:00");
            mainFrame.getTimeTrackerPanel().setPauseTime("00:00:00");
        }
    }

    private String formatDuration(Duration d) {
        long secs = d.getSeconds();
        long hh = secs / 3600;
        long mm = (secs % 3600) / 60;
        long ss = secs % 60;
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}
