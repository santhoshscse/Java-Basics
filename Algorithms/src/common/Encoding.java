package common;

import java.util.Scanner;

public class Encoding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]);
		long prev = Long.parseLong(str[0]);
		for (int i = 1; i < str.length; i++) {
			long parseLong2 = Long.parseLong(str[i]);
			long parseLong1 = Long.parseLong(str[i - 1]);
			long parseLong = parseLong2 - parseLong1;
			if (isValid(parseLong)) {
				sb.append(" ");
				sb.append(parseLong);
			} else {
				sb.append(" -128 ");
				sb.append(parseLong);
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static boolean isValid(long parseLong) {
		return !(parseLong < -127 || parseLong > 127);
	}
}
