package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdditionalCustomer {

	public static class Time {
		public Long st;
		public Long end;

		public Time(Long st, Long end) {
			this.st = st;
			this.end = end;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int executives = Integer.parseInt(sc.nextLine());
		// int executives = 1;

		Integer calls = Integer.parseInt(sc.nextLine());
		// Integer calls = 3;

		List<Time> list = new ArrayList<>();
		int required = 0;
		// String[] str1 = new String[] { "1481122000 1481122020", "1481122000
		// 1481122040", "1481122030 1481122035" };

		for (int i = 0; i < calls; i++) {

			String[] str = sc.nextLine().split(" ");
			// String[] str = str1[i].split(" ");

			long start = Long.parseLong(str[0]);
			long end = Long.parseLong(str[1]);
			Time time = new Time(start, end);

			if (list.size() == 0) {
				required++;
			} else if (isIntermediate(start, end, list)) {
				required++;
			}
			list.add(time);
		}

		System.out.println(required - executives);

	}

	private static boolean isIntermediate(long start, long end, List<Time> list) {
		int max = list.size();
		int count = 0;
		for (Time time : list) {
			if (start >= time.st && start <= time.end) {
				count++;
			} else if (end >= time.st && end <= time.end) {
				count++;
			} else {
				return false;
			}
		}
		return max == count;
	}

}
