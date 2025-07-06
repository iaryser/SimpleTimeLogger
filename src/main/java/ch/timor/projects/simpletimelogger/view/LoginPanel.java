package ch.timor.projects.simpletimelogger.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private final JLabel titleLabel = new JLabel("Login");
    private final JLabel userLabel = new JLabel("Username:");
    private final JTextField userNameField = new JTextField(20);
    private final JLabel passwordLabel = new JLabel("Passwort:");
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JButton loginButton = new JButton("Login");
    private final JButton registerButton = new JButton("Registrieren");

    public LoginPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Title
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 5, 30, 5);
        this.add(titleLabel, constraints);

        //Username label and form
        constraints.insets = new Insets(10, 5, 10,5);
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        this.add(userLabel, constraints);
        constraints.gridx = 1;
        this.add(userNameField, constraints);

        //Password label and form
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(passwordLabel, constraints);
        constraints.gridx = 1;
        this.add(passwordField, constraints);

        //Buttons
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(loginButton, constraints);

        constraints.gridx = 1;
        this.add(registerButton, constraints);

        //Adjusting some sizes
        Dimension fieldSize = new Dimension(200, 30);
        Dimension buttonSize = new Dimension(140, 30);
        userNameField.setPreferredSize(fieldSize);
        passwordField.setPreferredSize(fieldSize);
        loginButton.setPreferredSize(buttonSize);
        registerButton.setPreferredSize(buttonSize);

        //Adjusting font
        Font baseFont = userLabel.getFont();
        Font largerFont = baseFont.deriveFont(16f);
        userLabel.setFont(largerFont);
        passwordLabel.setFont(largerFont);
        loginButton.setFont(largerFont);
        registerButton.setFont(largerFont);
    }

    public void setActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
    }

    public String getUserName() {
        return this.userNameField.getText();
    }

    public String getPassword() {
        return this.passwordField.getText();
    }

    public JButton getLoginButton () {
        return this.loginButton;
    }

    public JButton getRegisterButton () {
        return this.registerButton;
    }
}
