

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSubList {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner sc = new Scanner(System.in);
		List<Integer> list1 = null;
		List<Integer> list2 = null;
		try {
			list1 = readList(sc);
			list2 = readList(sc);

			boolean found = false;
			for (int i = 0; i < list2.size(); i++) {
				if (!found) {
					for (int j = 0; j < list1.size(); j++) {
						if (list2.get(i).equals(list1.get(j))) {
							int match = checkMatch(i, j, list2, list1);
							if (match == -1) {
								System.out.println(-1);
								break;
							}
							if (match == 0) {
								found = true;
								System.out.println(j);
								break;
							}
							j = match;
						}
					}

				}

			}
		} catch (NumberFormatException e) {
			System.out.println(-1);
		}

	}

	private static int checkMatch(int i, int j, List<Integer> list2, List<Integer> list1) {
		if (list1.size() - j < list2.size() - i) {
			return -1;
		}
		for (int z = 0; z < list2.size(); z++) {
			if (list2.get(i).equals(list1.get(j))) {
				i++;
				j++;
			} else {
				return j;
			}
		}
		return 0;
	}

	private static List<Integer> readList(Scanner sc) {
		int s1 = Integer.parseInt(sc.nextLine());
		List<Integer> list1 = new ArrayList<>(s1);
		for (int i = 0; i < s1; i++) {
			list1.add(i, Integer.parseInt(sc.nextLine()));
		}
		return list1;
	}
}
