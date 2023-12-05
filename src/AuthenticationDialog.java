import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class AuthenticationDialog extends JDialog {
    private JPasswordField passwordField;
    private boolean authenticated = false;

    public AuthenticationDialog(JFrame parent) {
        super(parent, "Authentication", true);

        passwordField = new JPasswordField();
        JButton authenticateButton = new JButton("Authenticate");

        authenticateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String enteredPassword = new String(passwordField.getPassword());
                if (enteredPassword.equals("12345")) {
                    authenticated = true;
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(AuthenticationDialog.this, "Contraseña incorrecta");
                    passwordField.setText(""); 
                }
            }
        });

        setLayout(new GridLayout(2, 2));
        add(new JLabel("Contraseña:"));
        add(passwordField);
        add(new JLabel());
        add(authenticateButton);

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
