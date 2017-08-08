package common;

/**
 * @author santhoshsrinivasan
 *
 */
public class PartitionArray {
	public static void main(String[] args) {
		int[] t = { -5, -5, -5, -42, 6, -3, 12 };
		System.out.println(solution(t));
	}

	public static int solution(int[] T) {

		int length = T.length;
		int[] max = new int[length];
		int[] min = new int[length];
		max[0] = T[0];
		min[length - 1] = T[length - 1];
		for (int i = 1; i < length; i++) {
			if (T[i] > max[i - 1]) {
				max[i] = T[i];
			} else {
				max[i] = max[i - 1];
			}
		}

		for (int i = length - 2; i >= 0; i--) {
			if (T[i] < min[i + 1]) {
				min[i] = T[i];
			} else {
				min[i] = min[i + 1];
			}
		}

		for (int i = 0; i < length; i++) {
			if (max[i] < min[i + 1]) {
				return i + 1;
			}
		}
		return -1;
	}
}
