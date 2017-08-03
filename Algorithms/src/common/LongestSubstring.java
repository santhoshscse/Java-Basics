package common;


import java.util.Scanner;

/**
 * @author santhoshsrinivasan
 *
 */
public class LongestSubstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(lengthOfLongestSubstring(str));
	}

	// abcbcadbb
	public static int lengthOfLongestSubstring(String s) {
		StringBuilder sb = new StringBuilder();
		char[] charArr = s.toCharArray();
		int max = 0;
		for (int i = 0; i < charArr.length; i++) {
			int indexOf = sb.indexOf("" + charArr[i]);
			if (indexOf >= 0) {
				if (sb.length() > max) {
					max = sb.length();
				}
				sb.delete(0, indexOf+1);
				sb.append(charArr[i]);
			} else {
				sb.append(charArr[i]);
			}
		}
		if (sb.length() > max) {
			max = sb.length();
		}
		return max;
	}
}
