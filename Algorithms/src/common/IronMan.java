package common;

public class IronMan {

	public static void main(String[] args) {
		int[] in = { -5, 4, -2, 3, 2, 1, -1, -6, -1, 0, -5 };

		System.out.println(find(in));
	}

	/**
	 * @param in
	 * @return
	 */
	private static int find(int[] in) {
		int min = 0;
		int fmin = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] <= 0) {
				if (i > 1 && in[i - 1] > 0) {
					min += in[i - 1];
				}
				min += in[i];
			} else {
				if (fmin > min) {
					fmin = min;
					System.out.println(fmin);
				}

			}
		}
		if (fmin > min) {
			fmin = min;
			System.out.println(fmin);
		}
		return (-(fmin)) + 1;
	}
}
