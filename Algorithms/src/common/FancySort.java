package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FancySort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _exps_size = 0;
		_exps_size = Integer.parseInt(in.nextLine().trim());
		String[] _exps = new String[_exps_size];
		String _exps_item;
		for (int _exps_i = 0; _exps_i < _exps_size; _exps_i++) {
			try {
				_exps_item = in.nextLine();
			} catch (Exception e) {
				_exps_item = null;
			}
			_exps[_exps_i] = _exps_item;
		}

		fancySort(_exps);
	}

	/*
	 * Complete the function below.
	 */

	static void fancySort(String[] exps) {
		
		class InputExpress {
			String exp;
			int result;
		}

		List<InputExpress> list = new ArrayList<>();
		for (int i = 0; i < exps.length; i++) {

			try {

				String[] strArr = exps[i].split(",");
				String op = strArr[0];
				if (!isAllowedOp(op)) {
					continue;
				}
				int[] inArr = new int[strArr.length - 1];
				for (int j = 1; j < strArr.length; j++) {
					inArr[j - 1] = Integer.parseInt(strArr[j]);
				}

				InputExpress in = new InputExpress();
				in.exp = exps[i];
				in.result = getResult(op, inArr);
				list.add(in);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}

		Collections.sort(list, new Comparator<InputExpress>() {
			public int compare(InputExpress o1, InputExpress o2) {

				int res = o1.result - o2.result;
				if (res == 0) {
					res = o1.exp.compareTo(o2.exp);
				}
				return res;

			}
		});

		for (InputExpress in : list) {
			System.out.println(in.exp);
		}

	}

	private static int getResult(String op, int[] inArr) {
		switch (op) {
		case "ADD":
			return addOp(inArr);
		case "SUBTRACT":
			return subOp(inArr);
		case "MULTIPLY":
			return mulOp(inArr);
		case "DIVIDE":
			return divOp(inArr);
		case "MIN":
			return minOp(inArr);
		case "MAX":
			return maxOp(inArr);
		}
		return 0;
	}

	private static int maxOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res = Math.max(res, inArr[i]);
		}
		return res;
	}

	private static int minOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res = Math.min(res, inArr[i]);
		}
		return res;
	}

	private static int divOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res /= inArr[i];
		}
		return res;
	}

	private static int mulOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res *= inArr[i];
		}
		return res;
	}

	private static int subOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res -= inArr[i];
		}
		return res;
	}

	private static int addOp(int[] inArr) {
		int res = inArr[0];
		for (int i = 1; i < inArr.length; i++) {
			res += inArr[i];
		}
		return res;
	}

	static boolean isAllowedOp(String str) {
		return str.equals("ADD") || str.equals("SUBTRACT") || str.equals("MULTIPLY") || str.equals("DIVIDE")
				|| str.equals("MIN") || str.equals("MAX");

	}

}
