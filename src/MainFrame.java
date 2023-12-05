import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    private UserManager userManager;
    private ProductManager productManager;

    private JTextArea userTextArea;
    private JTextArea productTextArea;

    public MainFrame() {
        userManager = new UserManager();
        productManager = new ProductManager();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Interface");

        JButton registerUsersButton = new JButton("Register Users");
        JButton viewProductsButton = new JButton("View Products");

        registerUsersButton.addActionListener(e -> showRegisterUsersForm());
        viewProductsButton.addActionListener(e -> showViewProductsForm());

        // Crear el panel derecho con un BorderLayout
        JPanel rightPanel = new JPanel(new BorderLayout());
        userTextArea = new JTextArea("Users:\n");
        userTextArea.setEditable(false);
        JScrollPane userScrollPane = new JScrollPane(userTextArea);
        rightPanel.add(new JLabel("User Information"), BorderLayout.NORTH);
        rightPanel.add(userScrollPane, BorderLayout.CENTER);

        // Crear el panel izquierdo con un BorderLayout
        JPanel leftPanel = new JPanel(new BorderLayout());
        productTextArea = new JTextArea("Products:\n");
        productTextArea.setEditable(false);
        JScrollPane productScrollPane = new JScrollPane(productTextArea);
        leftPanel.add(new JLabel("Product Information"), BorderLayout.NORTH);
        leftPanel.add(productScrollPane, BorderLayout.CENTER);

        // Crear un JSplitPane con los paneles izquierdo y derecho
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.5);  // Establecer el ancho inicial del lado izquierdo

        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(registerUsersButton, BorderLayout.WEST);
        mainPanel.add(viewProductsButton, BorderLayout.EAST);
        mainPanel.add(splitPane, BorderLayout.CENTER);

        add(mainPanel);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void showRegisterUsersForm() {
        if (authenticate()) {
            RegisterUserForm registerUserForm = new RegisterUserForm(this, userManager);
            registerUserForm.setVisible(true);
            updateUserInfoTextArea();
        }
    }

    private void showViewProductsForm() {
        if (authenticate()) {
            ViewProductsForm viewProductsForm = new ViewProductsForm(this, productManager);
            viewProductsForm.setVisible(true);
            updateProductInfoTextArea();
        }
    }
    private boolean authenticate() {
        AuthenticationDialog authenticationDialog = new AuthenticationDialog(this);
        authenticationDialog.setVisible(true);
        return authenticationDialog.isAuthenticated();
    }
    
    private void updateUserInfoTextArea() {
        userTextArea.setText("Users:\n");
        for (User user : userManager.getUsers()) {
            userTextArea.append(user.toString() + "\n");
        }
    }

    private void updateProductInfoTextArea() {
        productTextArea.setText("Products:\n");
        for (Product product : productManager.getProducts()) {
            productTextArea.append(product.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}