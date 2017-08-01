package whatfix.robot;

import java.util.Stack;

public class Robot {
	public static void main(String[] args) {
		/*
		 * 1. Top left corner is considered as (0,0)
		 * 
		 * 2. Bottom right corner is considered as (m-1, n-1)
		 */
		int m = 4;
		int n = 3;

		int[][] visited = new int[m][n];
		Stack<String> stack = new Stack<String>();
		System.out.println("Total possible ways :" + findPossibleWays(0, 0, m - 1, n - 1, visited, stack));
	}

	private static int findPossibleWays(int s1, int s2, int e1, int e2, int[][] visited, Stack<String> sb) {
		// Invalid move
		if (s1 < 0 || s1 > e1 || s2 < 0 || s2 > e2) {
			return 0;
		}
		// Destination reached
		if (s1 == e1 && s2 == e2) {
			pushToStack(s1, s2, sb);
			printCurrentStack("Reached : ", sb);
			popFromStack(sb);
			return 1;
		}
		// Already visited, so invalid
		if (visited[s1][s2] == 1) {
			return 0;
		}
		int tmpCount = 0;
		visited[s1][s2] = 1;
		pushToStack(s1, s2, sb);
		// Move Left
		tmpCount += findPossibleWays(s1 - 1, s2, e1, e2, visited, sb);

		// Move Up
		tmpCount += findPossibleWays(s1, s2 - 1, e1, e2, visited, sb);

		// Move Right
		tmpCount += findPossibleWays(s1 + 1, s2, e1, e2, visited, sb);

		// Move Down
		tmpCount += findPossibleWays(s1, s2 + 1, e1, e2, visited, sb);

		visited[s1][s2] = 0;
		popFromStack(sb);
		return tmpCount;
	}

	private static void printCurrentStack(String res, Stack<String> sb) {
		System.out.println(res + sb.toString());
	}

	private static void popFromStack(Stack<String> sb) {
		sb.pop();
	}

	private static void pushToStack(int s1, int s2, Stack<String> sb) {
		sb.push("(" + s1 + "," + s2 + ")");
	}

}
