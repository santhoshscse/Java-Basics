package whatfix.packing;

/**
 * @author santhoshsrinivasan
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PackagingMainApp {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			Object[] in = Util.getAsInput(str);
			int packageWeight = (int) in[0];
			ArrayList<Item> items = (ArrayList<Item>) in[1];

			ArrayList<Item> retItems = PackingHelperUtil.fillBox(packageWeight, items);
			System.out.println(Util.getAsOutput(retItems));

		}

	}

}
