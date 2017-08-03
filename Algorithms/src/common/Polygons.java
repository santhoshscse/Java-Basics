package common;
import java.util.Scanner;

public class Polygons {
	public static void main(String[] args) {
		int noOfSquare = 0;
		int noOfRect = 0;
		int other = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(" ");
			int[] in = new int[4];
			boolean invalid = false;
			try {
				for (int i = 0; i < in.length; i++) {
					in[i] = Integer.parseInt(str[i]);
					if (in[i] <= 0) {
						invalid = true;
					}
				}
			} catch (NumberFormatException e) {
				invalid = true;
			}
			if (invalid) {
				other++;
			} else {
				int shape = getShape(in);
				if (shape == 1) {
					noOfSquare++;
				} else if (shape == 2) {
					noOfRect++;

				} else {
					other++;
				}
			}
		}
		System.out.println(noOfSquare + " " + noOfRect + " " + other);
	}

	static int getShape(int[] a) {
		if (a[0] == a[1]) {
			if (a[1] == a[2] && a[2] == a[3]) {
				return 1;
			}
		} else if (a[0] == a[2] && a[1] == a[3]) {
			return 2;
		} else if (a[0] == a[3] && a[1] == a[2]) {
			return 2;
		}
		return -1;
	}
}
