import java.io.Serializable;

class User implements Serializable {
    private String name, email, password, phone;

    public User(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}
