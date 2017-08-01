package whatfix.packing;

/**
 * @author santhoshsrinivasan
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
 * This class fills the box with list of items
 * */
public class PackingHelperUtil {
	public static ArrayList<Item> fillBox(int packageWeight, ArrayList<Item> inputItems) {
		ArrayList<Item> retItems = new ArrayList<>();
		ArrayList<Item> items = cleanupAndGet(packageWeight, inputItems);
		retItems = findMax(packageWeight, items, retItems, items.size());

		Collections.sort(retItems, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getIndex() - o2.getIndex();
			}
		});
		return retItems;
	}

	/*
	 * This method will remove items which are greater than packageWeight
	 */
	private static ArrayList<Item> cleanupAndGet(int packageWeight, ArrayList<Item> inputItems) {
		ArrayList<Item> items = (ArrayList<Item>) inputItems.stream().filter(item -> item.getWeight() <= packageWeight)
				.collect(Collectors.toList());
		return items;
	}

	private static ArrayList<Item> findMax(float remainingWeight, ArrayList<Item> availItems, ArrayList<Item> retItems,
			int n) {

		// Termination condition
		if (n == 0 || remainingWeight == 0) {
			return retItems;
		}

		Item item = availItems.get(n - 1);
		// If current item's weight > remainingWeight, process with other items
		if (item.getWeight() > remainingWeight) {
			return findMax(remainingWeight, availItems, retItems, n - 1);
		}

		// Include the current item & get total price
		ArrayList<Item> tmp1Items = new ArrayList<>(retItems);
		tmp1Items.add(item);
		tmp1Items = findMax(remainingWeight - item.getWeight(), availItems, tmp1Items, n - 1);

		// Without including current item, get total price
		ArrayList<Item> tmp2Items = new ArrayList<>(retItems);
		tmp2Items = findMax(remainingWeight, availItems, tmp2Items, n - 1);

		// Compare the total price & weight to determine which one to return
		int totalPrice1 = getTotalPrice(tmp1Items);
		int totalPrice2 = getTotalPrice(tmp2Items);
		if (totalPrice1 > totalPrice2) {
			return tmp1Items;
		} else if (totalPrice1 == totalPrice2) {
			float totalWeight1 = getTotalWeight(tmp1Items);
			float totalWeight2 = getTotalWeight(tmp2Items);
			if (totalWeight1 < totalWeight2) {
				return tmp1Items;
			} else {
				return tmp2Items;
			}
		} else {
			return tmp2Items;
		}
	}

	private static float getTotalWeight(ArrayList<Item> tmpItems) {
		float tot = 0;
		for (Item item : tmpItems) {
			tot += item.getWeight();
		}
		return tot;
	}

	private static int getTotalPrice(ArrayList<Item> tmpItems) {
		int tot = 0;
		for (Item item : tmpItems) {
			tot += item.getPrice();
		}
		return tot;
	}
}
