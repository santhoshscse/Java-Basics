package test.java.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparable implements Comparable<TestComparable> {

	private int a;

	public TestComparable(int a) {
		this.a = a;
	}

	@Override
	public int compareTo(TestComparable o) {
		return this.a - o.a;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestComparable [a=");
		builder.append(a);
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		sortByComparableClass();

		Comparator<TestComparable> comparator = new Comparator<TestComparable>() {

			@Override
			public int compare(TestComparable o1, TestComparable o2) {
				return o2.a - o1.a;
			}
		};
		sortByComparator(comparator);
		sortByComparatorReverse(comparator);

		Comparator<TestComparable> comparator2 = new Comparator<TestComparable>() {

			@Override
			public int compare(TestComparable o1, TestComparable o2) {
				return 0;
			}
		};
		sortByComparator(comparator2);
		sortByComparatorReverse(comparator2);
	}

	private static void sortByComparator(Comparator<TestComparable> comparator) {
		List<TestComparable> list = new ArrayList<>();
		list.add(new TestComparable(2));
		list.add(new TestComparable(1));
		list.add(new TestComparable(3));
		System.out.println();
		System.out.println("Before sorting " + list);
		Collections.sort(list, comparator);
		System.out.println("Sorted: based on comparator class \n" + list);
	}

	private static void sortByComparatorReverse(Comparator<TestComparable> comparator) {
		List<TestComparable> list = new ArrayList<>();
		list.add(new TestComparable(2));
		list.add(new TestComparable(1));
		list.add(new TestComparable(3));
		System.out.println();
		System.out.println("Before sorting " + list);
		Collections.sort(list, comparator.reversed());
		System.out.println("Sorted: based on comparator class \n" + list);
	}

	private static void sortByComparableClass() {
		List<TestComparable> list = new ArrayList<>();
		list.add(new TestComparable(2));
		list.add(new TestComparable(1));
		list.add(new TestComparable(3));
		System.out.println();
		System.out.println("Before sorting " + list);
		Collections.sort(list);
		System.out.println("Sorted: class implements comparable class \n" + list);
	}

}
