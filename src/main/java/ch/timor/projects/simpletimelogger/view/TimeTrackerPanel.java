package ch.timor.projects.simpletimelogger.view;

import javax.swing.*;
import java.awt.*;

public class TimeTrackerPanel extends JPanel {
    private final JLabel title = new JLabel("Time Logger");
    private final JButton quitButton = new JButton("Beenden");
    private final JButton startWorkButton = new JButton("Einstempeln");
    private final JButton startPauseButton = new JButton("Pause");
    private final JLabel workTimeLabel = new JLabel("Momentane Arbeitszeit: ");
    private final JLabel workTimeDisplay = new JLabel("00:00:00");
    private final JLabel pauseTimeLabel = new JLabel("Insgesamte Pause: ");
    private final JLabel pauseTimeDisplay = new JLabel("00:00:00");

    public TimeTrackerPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Title
        this.title.setFont(new Font("Arial", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 5, 5, 5);
        this.add(this.title, constraints);

        // Reset gridwidth so subsequent components span only one column
        constraints.gridwidth = 1;

        constraints.insets = new Insets(5, 5, 5, 5);
        // Quit button
        constraints.gridx = 5;
        constraints.weightx = 0;                    // no extra horizontal weight
        constraints.fill = GridBagConstraints.NONE;
        this.quitButton.setBackground(Color.RED);
        this.quitButton.setPreferredSize(new Dimension(100, 30));
        this.add(this.quitButton, constraints);

        constraints.insets = new Insets(100, 30, 50, 30);

        // Start Work button
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0.5;                  // give this column some weight
        constraints.fill = GridBagConstraints.HORIZONTAL; // allow horizontal expansion
        this.startWorkButton.setBackground(Color.DARK_GRAY);
        this.startWorkButton.setForeground(Color.WHITE);
        this.startWorkButton.setPreferredSize(new Dimension(200, 50));
        this.add(this.startWorkButton, constraints);

        // Pause button
        constraints.gridx = 3;
        constraints.weightx = 0.5;                  // give this column some weight
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.startPauseButton.setBackground(Color.DARK_GRAY);
        this.startPauseButton.setForeground(Color.WHITE);
        this.startPauseButton.setPreferredSize(new Dimension(200, 50));
        this.add(this.startPauseButton, constraints);


        // Reset weight and fill for labels
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(20, 30, 10, 30);

        // Work time display
        constraints.gridx = 1;
        constraints.gridy = 5;
        this.add(this.workTimeLabel, constraints);
        constraints.gridx = 2;
        this.add(this.workTimeDisplay, constraints);

        constraints.insets = new Insets(20, 30, 200, 30);

        // Pause display
        constraints.gridx = 1;
        constraints.gridy = 7;
        this.add(this.pauseTimeLabel, constraints);
        constraints.gridx = 2;
        this.add(this.pauseTimeDisplay, constraints);

        // Adjusting font
        Font baseFont = this.workTimeLabel.getFont();
        Font largerFont = baseFont.deriveFont(16f);
        this.workTimeLabel.setFont(largerFont);
        this.workTimeDisplay.setFont(largerFont);
        this.pauseTimeLabel.setFont(largerFont);
        this.pauseTimeDisplay.setFont(largerFont);
        this.startPauseButton.setFont(largerFont);
        this.startWorkButton.setFont(largerFont);
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getStartPauseButton() {
        return startPauseButton;
    }

    public JButton getStartWorkButton() {
        return startWorkButton;
    }

    public void setWorkTime(String hhmmss) {
        this.workTimeDisplay.setText(hhmmss);
    }

    public void setPauseTime(String hhmmss) {
        this.pauseTimeDisplay.setText(hhmmss);
    }
}
