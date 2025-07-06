package ch.timor.projects.simpletimelogger.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    private final JLabel title = new JLabel("Registrierung");
    private final JLabel firstNameLabel = new JLabel("Vorname:");
    private final JTextField firstNameField = new JTextField(20);
    private final JLabel lastNameLabel = new JLabel("Nachname:");
    private final JTextField lastNameField = new JTextField(20);
    private final JLabel userNameLabel = new JLabel("Username:");
    private final JTextField userNameField = new JTextField(20);
    private final JLabel passwordLabel = new JLabel("Passwort:");
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JButton submitButton = new JButton("Account erstellen");

    public RegisterPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;

        //Title
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 5, 30, 5);
        this.add(title, constraints);

        //firstname
        constraints.insets = new Insets(10, 5, 10,5);
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        this.add(firstNameLabel, constraints);
        constraints.gridx = 1;
        this.add(firstNameField, constraints);

        //lastname
        constraints.gridy = 2;
        constraints.gridx = 0;
        this.add(lastNameLabel, constraints);
        constraints.gridx = 1;
        this.add(lastNameField, constraints);

        //username
        constraints.gridy = 3;
        constraints.gridx = 0;
        this.add(userNameLabel, constraints);
        constraints.gridx = 1;
        this.add(userNameField, constraints);

        //password
        constraints.gridy = 4;
        constraints.gridx = 0;
        this.add(passwordLabel, constraints);
        constraints.gridx = 1;
        this.add(passwordField, constraints);

        //submit button
        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;
        this.add(submitButton, constraints);

        //Adjusting some sizes
        Dimension fieldSize = new Dimension(200, 30);
        Dimension buttonSize = new Dimension(200, 30);
        this.firstNameField.setPreferredSize(fieldSize);
        this.lastNameField.setPreferredSize(fieldSize);
        this.userNameField.setPreferredSize(fieldSize);
        this.passwordField.setPreferredSize(fieldSize);
        this.submitButton.setPreferredSize(buttonSize);

        //Adjusting font
        Font baseFont = firstNameLabel.getFont();
        Font largerFont = baseFont.deriveFont(16f);
        this.firstNameLabel.setFont(largerFont);
        this.lastNameLabel.setFont(largerFont);
        this.userNameLabel.setFont(largerFont);
        this.passwordLabel.setFont(largerFont);
        this.submitButton.setFont(largerFont);
    }

    public void setActionListener(ActionListener listener) {
        this.submitButton.addActionListener(listener);
    }

    public String getFirstName() {
        return this.firstNameField.getText();
    }

    public String getLastName() {
        return this.lastNameField.getText();
    }
    public String getUserName() {
        return this.userNameField.getText();
    }
    public String getPassword() {
        return new String(this.passwordField.getPassword());
    }


    public JButton getSubmitButton() {
        return this.submitButton;
    }
}
