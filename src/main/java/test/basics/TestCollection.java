package test.basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestCollection {
	public static void main(String[] args) {
		testList();
		testSet();
		testMap();
	}

	private static void testMap() {
		testHashMap();
		testLinkedHashMap();
		testTreeMap();
		testTreeMapWithComparator();
	}

	private static void testTreeMapWithComparator() {

		Comparator<Entry<Integer, String>> comp = new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		};

		Comparator<Integer> mapcomp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};

		System.out.println("Start testTreeMapWithComparator");
		Map<Integer, String> list = new TreeMap<>(mapcomp);
		list.put(2, "2");
		list.put(1, "1");
		try {
			list.put(null, "nullvaluefinal");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Order : Maintained, based on comparartor " + list);
		System.out.println(
				"Extra : 1. Null is not allowed, 2. No duplicate keys, 3. Same as HashTable, but not syncronised");
		System.out.println("Random access : Yes. So can get value specific key " + list.get(2));
		System.out.println("End testTreeMapWithComparator");
	}

	private static void testTreeMap() {
		System.out.println("Start testTreeMap");
		Map<Integer, String> list = new TreeMap<>();
		list.put(2, "2");
		list.put(1, "1");
		try {
			list.put(null, "nullvaluefinal");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Order : Not maintained" + list);
		System.out.println(
				"Extra : 1. Null is not allowed, 2. No duplicate keys, 3. Same as HashTable, but not syncronised");
		System.out.println("Random access : Yes. So can get value specific key " + list.get(2));
		System.out.println("End testTreeMap");
	}

	private static void testLinkedHashMap() {
		System.out.println("Start testLinkedHashMap");
		Map<Integer, String> list = new LinkedHashMap<>();
		list.put(2, "2");
		list.put(1, "1");
		list.put(null, "nullvalue1");
		list.put(null, "nullvaluefinal");
		System.out.println("Order : Maintained" + list);
		System.out
				.println("Extra : 1. Null is allowed, 2. No duplicate keys, 3. Same as HashTable, but not syncronised");
		System.out.println("Random access : Yes. So can get value specific key " + list.get(null));
		System.out.println("End testLinkedHashMap");

	}

	private static void testHashMap() {
		System.out.println("Start testHashMap");
		Map<Integer, String> list = new HashMap<>();
		list.put(2, "2");
		list.put(1, "1");
		list.put(null, "nullvalue");
		System.out.println("Order : Not Maintained" + list);
		System.out
				.println("Extra : 1. Null is allowed, 2. No duplicate keys, 3. Same as HashTable, but not syncronised");
		System.out.println("Random access : Yes. So can get value specific key " + list.get(null));
		System.out.println("End testHashMap");
	}

	private static void testSet() {
		testHashSet();
		testLinkedHashSet();
		testTreeSet();
		testTreeSetWithComparator();
	}

	private static void testTreeSetWithComparator() {
		System.out.println("Start testTreeSetWithComparator");
		Set<String> list = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.charAt(0) - o1.charAt(0);
			}
		});
		list.add("1");
		list.add("11");
		list.add("2");
		list.add("1");
		try {
			list.add(null);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add("0");
		list.add("4");
		System.out.println("Order : Maintained based on comparator" + list);
		System.out.println(
				"Extra : 1. TreeMap & NavigableSet is backed, 2. Null is not allowed, 3. Based on compartor elements are checked for duplicates, thats why 11 is not inserted");
		System.out.println("Random access : No. So cant get value specific index 1 ");
		System.out.println("End testTreeSetWithComparator");
	}

	private static void testTreeSet() {
		System.out.println("Start testTreeSet");
		Set<String> list = new TreeSet<>();
		list.add("1");
		list.add("2");
		list.add("1");
		try {
			list.add(null);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add("0");
		list.add("4");
		System.out.println("Order : Maintained " + list);
		System.out.println("Extra : TreeMap & NavigableSet is backed, null is not allowed");
		System.out.println("Random access : No. So cant get value specific index 1 ");
		System.out.println("End testTreeSet");
	}

	private static void testLinkedHashSet() {
		System.out.println("Start testLinkedHashSet");
		Set<String> list = new LinkedHashSet<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add(null);
		list.add("0");
		list.add("4");
		System.out.println("Order : Maintained " + list);
		System.out.println("Extra : LinkedHashMap is backed");
		System.out.println("Random access : No. So cant get value specific index 1 ");
		System.out.println("End testLinkedHashSet");
	}

	private static void testHashSet() {
		System.out.println("Start testHashSet");
		Set<String> list = new HashSet<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add(null);
		list.add("0");
		list.add("4");
		System.out.println("Order : Not maintained " + list);
		System.out.println("Extra : HashMap is backed");
		System.out.println("Random access : No. So cant get value specific index 1 ");
		System.out.println("End testHashSet");
	}

	private static void testList() {
		testArrayList();
		testLinkedList();
	}

	private static void testLinkedList() {
		System.out.println("Start testLinkedList");
		List<String> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add(null);
		System.out.println("Order: Maintained " + list);
		System.out.println("Null: Allowed");
		System.out.println("Random access : No, Sequencial access. Element at the index 1 " + list.get(1)
				+ ". This is possible because it start searching from first or last. So it is not random access actually, it is sequencial access");
		System.out.println("End testLinkedList");
	}

	private static void testArrayList() {
		System.out.println("Start testArrayList");
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add(null);
		System.out.println("Order: Maintained " + list);
		System.out.println("Null: Allowed");
		System.out.println("Random access : Yes, Element at the index 1 " + list.get(1));
		System.out.println("End testArrayList");
	}

}
