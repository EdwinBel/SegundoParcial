import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class ProductManager {
    private List<Product> products;
    private static final String FILE_PATH = "data/products.txt";

    public ProductManager() {
        products = new ArrayList<>();
        loadProductsFromFile();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle the exception
        }
    }
}
