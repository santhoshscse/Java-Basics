package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelReview {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			keys.add(str[i].toLowerCase());
		}

		Map<Integer, Integer> hotelReview = new HashMap<>();
		int review = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < review; i++) {
			int id = Integer.parseInt(sc.nextLine());
			String[] in = sc.nextLine().split(" ");
			int tmpCount = 0;
			for (int j = 0; j < in.length; j++) {
				if (in[j].endsWith(",") || in[j].endsWith(".")) {
					in[j] = in[j].substring(0, in[j].length() - 1).toLowerCase();
				}
				if (keys.contains(in[j])) {
					tmpCount++;
				}
			}
			Integer existVal = hotelReview.get(id);
			if (existVal != null) {
				hotelReview.put(id, existVal.intValue() + tmpCount);
			} else {
				hotelReview.put(id, tmpCount);
			}
		}
		Set<Integer> keySet = sortByValue(hotelReview).keySet();
		System.out.println(keySet);
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
