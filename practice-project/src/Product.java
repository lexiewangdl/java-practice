
public class Product {
	private long itemno;
	private String name;
	private double price;
	private double quantity;

	public long getItemNumber() {
		return itemno;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double q) {
		quantity = q;
	}

	// Constructors
	public Product(long num, String n, double pr, double q) {
		itemno = num;
		name = n;
		price = pr;
		quantity = q;
	}

	public static void main(String[] args) {
		Product p = new Product(19728192, "Daily Planner", 30, 5);

		System.out.println("Item Number: " + p.getItemNumber());
		System.out.println("Item Name: " + p.getName());
		System.out.println("Item Quantity: " + p.getQuantity());
	}
}
