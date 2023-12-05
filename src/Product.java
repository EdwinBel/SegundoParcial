import java.io.Serializable;

class Product implements Serializable {
    private String name, description, type;
    private double price;

    public Product(String name, String description, String type, double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Type: " + type + ", Price: " + price;
    }

}