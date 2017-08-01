package whatfix.packing;

import java.util.ArrayList;
import java.util.List;

/*
 * This class helps 
 * 1. to convert from file lines to items object
 * 2. to calculate total
 * 3. to convert items to desired output 
 * */
public class Util {
	

	public static Object[] getAsInput(String str) {
		String[] tmp1 = str.split(":");
		int packageWeight = Integer.parseInt(tmp1[0].trim());
		String[] tmp2 = tmp1[1].trim().split(" ");
		List<Item> items = getAsItemsList(tmp2);
		return new Object[] { packageWeight, items };
	}

	private static ArrayList<Item> getAsItemsList(String[] tmp2) {
		ArrayList<Item> items = new ArrayList<Item>(tmp2.length);
		for (int i = 0; i < tmp2.length; i++) {
			Item item = getAsItem(tmp2[i]);
			items.add(item);
		}
		return items;
	}

	private static Item getAsItem(String string) {
		string = string.substring(1, string.length() - 1);
		String[] data = string.split(",");
		return new Item(Integer.parseInt(data[0]), Float.parseFloat(data[1]), Integer.parseInt(data[2].substring(1)));
	}

	public static String getAsOutput(ArrayList<Item> retItems) {
		if (retItems.size() == 0) {
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		for (Item item : retItems) {
			if (sb.length() != 0) {
				sb.append(',');
			}
			sb.append(item.getIndex());
		}
		return sb.toString();
	}
}
