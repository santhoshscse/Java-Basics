import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author santhoshsrinivasan
 *
 */
public class RotationArray {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int[] res;

		int _a_size = 0;
		_a_size = Integer.parseInt(in.nextLine().trim());
		int[] _a = new int[_a_size];
		int _a_item;
		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(in.nextLine().trim());
			_a[_a_i] = _a_item;
		}

		int _rotate_size = 0;
		_rotate_size = Integer.parseInt(in.nextLine().trim());
		int[] _rotate = new int[_rotate_size];
		int _rotate_item;
		for (int _rotate_i = 0; _rotate_i < _rotate_size; _rotate_i++) {
			_rotate_item = Integer.parseInt(in.nextLine().trim());
			_rotate[_rotate_i] = _rotate_item;
		}

		res = getMaxElementIndices(_a, _rotate);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(res[res_i]);
			 bw.write(String.valueOf(res[res_i]));
			 bw.newLine();
		}

		 bw.close();
	}

	private static int[] getMaxElementIndices(int[] _a, int[] _rotate) {
		int res[] = new int[_rotate.length];
		for (int i = 0; i < _rotate.length; i++) {
			int[] _res = _a;
			for (int j = 0; j < _rotate[i]; j++) {
				_res = rotate(_res);
			}
			res[i] = findMaxIndex(_res);
		}
		return res;
	}

	private static int[] rotate(int[] _a) {
		int[] res = new int[_a.length];
		int count = 0;
		for (int i = 1; i < _a.length; i++) {
			res[count++] = _a[i];
		}
		res[count] = _a[0];

		return res;
	}

	private static int findMaxIndex(int[] _a) {
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < _a.length; i++) {
			if (max < _a[i]) {
				max = _a[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}

// 4
// 1 2 4 3
// 2
// 1 3
// 1 3