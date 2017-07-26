
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Combinations {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int noOfLines = Integer.parseInt(line);
		for (int l = 0; l < noOfLines; l++) {
			line = br.readLine();
			int N = Integer.parseInt(line);

			String[] notKsl = new String[] { "abc", "acb", "bac", "bca", "cab", "cba" };
			String[] res = print(N);
			int count = 0;
			for (int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
				boolean found = false;
				for (String notksl : notKsl) {
					if (res[i].contains(notksl)) {
						found = true;
						break;
					}
				}
				if (found) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static String[] print(int n) {
		if (n == 1) {
			return new String[] { "a", "b", "c" };
		} else {
			String[] res = print(n - 1);
			String[] temp = new String[res.length * 3];
			int count = 0;
			for (int i = 0; i < res.length; i++) {
				temp[count++] = res[i] + "a";
				temp[count++] = res[i] + "b";
				temp[count++] = res[i] + "c";
			}
			return temp;
		}
	}
}
