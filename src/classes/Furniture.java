package classes;

public class Furniture {

	// Vars
	private int id, category, stock;
	private String name, description, pictureFile;
	private float price;

	// Constructor
	public Furniture(int id, int category, int stock, String name, String description, String pictureFile,
			float price) {
		this.id = id;
		this.category = category;
		this.stock = stock;
		this.name = name;
		this.description = description;
		this.pictureFile = pictureFile;
		this.price = price;
	}

	// Getters/Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public String getPictureFile() {
		return pictureFile;
	}

	public void setPictureFile(String pictureFile) {
		this.pictureFile = pictureFile;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
