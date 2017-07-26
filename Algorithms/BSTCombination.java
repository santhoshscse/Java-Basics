import java.util.HashMap;

public class BSTCombination {

	public static void main(String[] args) {
		System.out.println(new BSTCombination().numTrees(100));
	}

	HashMap res = new HashMap<Integer, Integer>();

	public int numTrees(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (res.get(n) == null) {
			int count = 0;
			for (int i = 1; i <= n; i++) {
				count += numTrees(i - 1) * numTrees(n - i);
			}
			res.put(n, count);
			return count;
		} else {
			return (int) res.get(n);
		}
	}
}