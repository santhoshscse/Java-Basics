
import java.util.Scanner;

/**
 * @author santhoshsrinivasan
 *
 */
public class ArrayEqualibrium {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int nofTestCases = Integer.parseInt(sc.nextLine());
		String[] resultArr = new String[nofTestCases];
		for (int i = 0; i < nofTestCases; i++) {
			int noOfElements = Integer.parseInt(sc.nextLine());
			int[] inArr = new int[noOfElements];
			String[] str = sc.nextLine().split(" ");
			for (int j = 0; j < inArr.length; j++) {
				inArr[j] = Integer.parseInt(str[j]);
			}
			if (findIndex(inArr) > 0) {
				resultArr[i] = "YES";
			} else {
				resultArr[i] = "NO";
			}
		}
		for (int i = 0; i < nofTestCases; i++) {
			System.out.println(resultArr[i]);
		}
	}

	private static int findIndex(int[] a) {

		int start = -1;
		int end = a.length;
		int sum1 = 0;
		int sum2 = 0;
		while (true) {
			if (sum1 == sum2) {
				start++;
				end--;
				sum1 += a[start];
				sum2 += a[end];
			} else if (sum1 > sum2 && sum1 > 0) {
				end--;
				sum2 += a[end];
			} else {
				start++;
				sum1 += a[start];
			}
			if (start >= end) {
				break;
			}
		}
		if (sum1 == sum2 && start == end) {
			return start;
		} else {
			return -1;
		}
	}
}
