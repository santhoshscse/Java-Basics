package whatfix.packing;

/**
 * @author santhoshsrinivasan
 *
 */
public class Item {

	private int index;
	private float weight;
	private int price;

	public Item(int index, float weight, int price) {
		this.index = index;
		this.weight = weight;
		this.price = price;

	}

	public float getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Item [weight=" + weight + ", price=" + price + ", index=" + index + "]";
	}

}