import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ViewProductsForm extends JFrame {
    private ProductManager productManager;
    private JTable productTable;

    public ViewProductsForm(JFrame parent, ProductManager productManager) {
        super("View Products");
        this.productManager = productManager;

        productTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(productTable);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> updateProductTable());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(refreshButton, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setLocationRelativeTo(parent);

        updateProductTable();
    }

    private void updateProductTable() {
        List<Product> products = productManager.getProducts();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Description");
        tableModel.addColumn("Type");
        tableModel.addColumn("Price");

        for (Product product : products) {
            Object[] rowData = {product.getName(), product.getDescription(), product.getType(), product.getName()};
            tableModel.addRow(rowData);
        }

        productTable.setModel(tableModel);
    }
}

