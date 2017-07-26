import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * s vinaayak
 * s vasu
 * s vinaayak mahedev
 * s vivek
 * s varunesh
 * s varun kannan
 * s varun ragavan
 * s varun anand
 * s varun aadithya
 * s varun aswin
 * s varun Aadavan
 * s varun bairavan
 * s varun Bhupathi
 * s varun ishwar
 * s varun laxman
 * s varun laksman
 * s varun akhilan
 * s varun udhaya


 * */
/**
 * 1 = A, I, J, Q, Y
 * 
 * 2 = B, K, R
 * 
 * 3 = C, G, L, S
 * 
 * 4 = D, M, T
 * 
 * 5 = E, H, N, X
 * 
 * 6 = U, V, W
 * 
 * 7 = O, Z
 * 
 * 8 = F, P
 */

/**
 * 5 6 
 * */

/**
 * TN 20 CY 0864
 * */

/**
 * Athirstam = 1 3 6 9 10 14 15 16 18 21 24 27 32 33 36 42 46 50 51
 * 
 * Miga miga Athirstam = 19 23 37 41 45
 * 
 * Sumar = 2 12 30 38 39 48 54 57
 * 
 * Ethiriya alipathu = 20 52 55
 * 
 * Abathu = 26 29 35 4 53
 * 
 * Very bad = 11 13 17 22 28 31 40 49 58
 * 
 * Very very bad = 56
 * 
 * Sothanai = 25 43 47 34
 * 
 */

public class Numerology {
	enum Cat {
		Athirstam, MigaMigaAthirstam, Sumar, EthiriyaiAzhipathu, Abathu, VeryVeryBad, VeryBad;
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> alphaNumeric = getAlphaVsNumeric();
		HashMap<Integer, Cat> numberCategory = getNumberVsCategory();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		while (!(line = br.readLine()).isEmpty()) {

			String[] datas = line.split("\\ ");

			printCombinations(alphaNumeric, numberCategory, datas);
		}

	}

	private static void printCombinations(HashMap<String, Integer> alphaNumeric, HashMap<Integer, Cat> numberCategory,
			String[] datas) {
		int total = 0;
		if (datas.length > 2) {
			System.out.print(datas[0] + " " + datas[1] + " " + datas[2] + " :: ");
			total = getTotal(alphaNumeric, datas[0] + datas[1] + datas[2]);
			System.out.print(total + " :: ");
			System.out.println(numberCategory.get(total));
		}

		System.out.print(datas[0] + " " + datas[1] + " :: ");
		total = getTotal(alphaNumeric, datas[0] + datas[1]);
		System.out.print(total + " :: ");
		System.out.println(numberCategory.get(total));

		if (datas.length > 2) {
			System.out.print(datas[1] + " " + datas[2] + " :: ");
			total = getTotal(alphaNumeric, datas[1] + datas[2]);
			System.out.print(total + " :: ");
			System.out.println(numberCategory.get(total));
		}

		System.out.print(datas[1] + " :: ");
		total = getTotal(alphaNumeric, datas[1]);
		System.out.print(total + " :: ");
		System.out.println(numberCategory.get(total));

		if (datas.length > 2) {
			System.out.print(datas[2] + " :: ");
			total = getTotal(alphaNumeric, datas[2]);
			System.out.print(total + " :: ");
			System.out.println(numberCategory.get(total));
		}
	}

	private static int getTotal(HashMap<String, Integer> alphaNumeric, String input) {

		int total = 0;
		for (int i = 0; i < input.length(); i++) {
			total += alphaNumeric.get((input.charAt(i) + "").toUpperCase());
		}

		if (total > 58) {
			int value = total;
			total = 0;
			while (value > 0) {
				total += value % 10;
				value = value / 10;
			}
		}

		return total;
	}

	

	private static HashMap<Integer, Cat> getNumberVsCategory() {

		HashMap<Integer, Cat> numberCategory = new HashMap<>();

		// Athirstam = 1 3 6 9 10 14 15 16 18 21 24 27 32 33 36 42 46 50 51
		numberCategory.put(1, Cat.Athirstam);
		numberCategory.put(3, Cat.Athirstam);
		numberCategory.put(6, Cat.Athirstam);
		numberCategory.put(9, Cat.Athirstam);
		numberCategory.put(10, Cat.Athirstam);
		numberCategory.put(14, Cat.Athirstam);
		numberCategory.put(15, Cat.Athirstam);
		numberCategory.put(16, Cat.Athirstam);
		numberCategory.put(18, Cat.Athirstam);
		numberCategory.put(21, Cat.Athirstam);
		numberCategory.put(24, Cat.Athirstam);
		numberCategory.put(27, Cat.Athirstam);
		numberCategory.put(32, Cat.Athirstam);
		numberCategory.put(33, Cat.Athirstam);
		numberCategory.put(36, Cat.Athirstam);
		numberCategory.put(42, Cat.Athirstam);
		numberCategory.put(46, Cat.Athirstam);
		numberCategory.put(50, Cat.Athirstam);
		numberCategory.put(51, Cat.Athirstam);

		// Miga miga Athirstam = 19 23 37 41 45
		numberCategory.put(19, Cat.MigaMigaAthirstam);
		numberCategory.put(23, Cat.MigaMigaAthirstam);
		numberCategory.put(37, Cat.MigaMigaAthirstam);
		numberCategory.put(41, Cat.MigaMigaAthirstam);
		numberCategory.put(45, Cat.MigaMigaAthirstam);

		// Sumar = 2 12 30 38 39 48 54 57
		numberCategory.put(2, Cat.Sumar);
		numberCategory.put(12, Cat.Sumar);
		numberCategory.put(30, Cat.Sumar);
		numberCategory.put(38, Cat.Sumar);
		numberCategory.put(39, Cat.Sumar);
		numberCategory.put(48, Cat.Sumar);
		numberCategory.put(54, Cat.Sumar);
		numberCategory.put(57, Cat.Sumar);

		// Ethiriya alipathu = 20 52 55
		numberCategory.put(20, Cat.EthiriyaiAzhipathu);
		numberCategory.put(52, Cat.EthiriyaiAzhipathu);
		numberCategory.put(55, Cat.EthiriyaiAzhipathu);

		// Abathu = 26 29 35 4 53
		numberCategory.put(26, Cat.Abathu);
		numberCategory.put(29, Cat.Abathu);
		numberCategory.put(35, Cat.Abathu);
		numberCategory.put(4, Cat.Abathu);
		numberCategory.put(53, Cat.Abathu);

		// Very bad = 11 13 17 22 28 31 40 49 58
		numberCategory.put(11, Cat.VeryBad);
		numberCategory.put(13, Cat.VeryBad);
		numberCategory.put(17, Cat.VeryBad);
		numberCategory.put(22, Cat.VeryBad);
		numberCategory.put(28, Cat.VeryBad);
		numberCategory.put(31, Cat.VeryBad);
		numberCategory.put(40, Cat.VeryBad);
		numberCategory.put(49, Cat.VeryBad);
		numberCategory.put(58, Cat.VeryBad);

		// Very very bad = 56
		// Sothanai = 25 43 47 34

		numberCategory.put(56, Cat.VeryVeryBad);
		numberCategory.put(25, Cat.VeryVeryBad);
		numberCategory.put(43, Cat.VeryVeryBad);
		numberCategory.put(47, Cat.VeryVeryBad);
		numberCategory.put(34, Cat.VeryVeryBad);

		return numberCategory;
	}

	private static HashMap<String, Integer> getAlphaVsNumeric() {
		HashMap<String, Integer> alphaNumeric = new HashMap<>();
		alphaNumeric.put("A", 1);
		alphaNumeric.put("I", 1);
		alphaNumeric.put("J", 1);
		alphaNumeric.put("Q", 1);
		alphaNumeric.put("Y", 1);

		alphaNumeric.put("B", 2);
		alphaNumeric.put("K", 2);
		alphaNumeric.put("R", 2);

		alphaNumeric.put("C", 3);
		alphaNumeric.put("G", 3);
		alphaNumeric.put("L", 3);
		alphaNumeric.put("S", 3);

		alphaNumeric.put("D", 4);
		alphaNumeric.put("M", 4);
		alphaNumeric.put("T", 4);

		alphaNumeric.put("H", 5);
		alphaNumeric.put("E", 5);
		alphaNumeric.put("N", 5);
		alphaNumeric.put("X", 5);

		alphaNumeric.put("U", 6);
		alphaNumeric.put("V", 6);
		alphaNumeric.put("W", 6);

		alphaNumeric.put("O", 7);
		alphaNumeric.put("Z", 7);

		alphaNumeric.put("P", 8);
		alphaNumeric.put("F", 8);
		return alphaNumeric;
	}
}
