package common;


public class BomberAlgorithm {

	public static void main(String[] args) {
		String str = "abbabba";
		while (true) {
			String outStr = applyBomberAlg(str);
			if (str.equals(outStr)) {
				System.out.println("Final output :"+outStr);
				break;
			} else {
				str = outStr;
				System.out.println(str);
			}
		}
	}

	private static String applyBomberAlg(String str) {
		char[] charArr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		char prev = 0;
		boolean appendPrev = true;
		int i = 0;
		for (i = 0; i < charArr.length; i++) {
			if (prev == 0) {
				prev = charArr[i];
			} else if (prev != charArr[i]) {
				if (appendPrev) {
					sb.append(prev);
				} else {
					break;
				}
				prev = charArr[i];

			} else {
				appendPrev = false;
			}
		}
		if (appendPrev) {
			sb.append(prev);
		}
		for (int j = i; j < charArr.length; j++) {
			sb.append(charArr[j]);
		}
		return sb.toString();
	}

}