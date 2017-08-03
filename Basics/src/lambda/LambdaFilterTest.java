package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author santhoshsrinivasan
 *
 */
public class LambdaFilterTest {
	public static void main(String[] args) {
		List<String> in = new ArrayList<>();
		in.add("someone");
		in.add("santhosh");
		in.add("santhoshs");
		in.add("ssanthosh");
		in.add("someone");

		in.stream().filter(name -> name.contains("santhosh")).collect(Collectors.toList());
	}
}
