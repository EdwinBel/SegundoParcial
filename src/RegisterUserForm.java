import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class RegisterUserForm extends JFrame {
    private UserManager userManager;
    private JTextField nameField, emailField, passwordField, phoneField;

    public RegisterUserForm(JFrame parent, UserManager userManager) {
        super("Register Users");
        this.userManager = userManager;

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);
        add(new JLabel("Password:"));
        passwordField = new JTextField();
        add(passwordField);
        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> registerUser());
        add(registerButton);

        pack();
        setLocationRelativeTo(parent);
    }

    private void registerUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String phone = phoneField.getText();

        User newUser = new User(name, email, password, phone);
        userManager.addUser(newUser);

        userManager.saveUsersToFile();

        dispose();
    }
}