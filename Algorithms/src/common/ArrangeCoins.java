package common;

import java.util.HashMap;
import java.util.Scanner;

public class ArrangeCoins {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _coins_size = 0;
		_coins_size = Integer.parseInt(in.nextLine().trim());
		long[] _coins = new long[_coins_size];
		long _coins_item;
		for (int _coins_i = 0; _coins_i < _coins_size; _coins_i++) {
			_coins_item = Long.parseLong(in.nextLine().trim());
			_coins[_coins_i] = _coins_item;
		}

		arrangeCoins(_coins);

	}

	private static void arrangeCoins(long[] _coins) {
		for (int i = 0; i < _coins.length; i++) {
			int count = 0;
			long val = _coins[i];
			while (val > count) {
				count++;
				val = val - (long) count;
			}
			System.out.println(count);
		}
	}
}
