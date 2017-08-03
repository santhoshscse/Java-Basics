package basics;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	class A {
		private String a = "a";

		public void print() {
			System.out.println(a);
		}
	}

	class B extends A {
		private String a = "b";

		@Override
		public void print() {
			System.out.println(a);
		}
	}

	class C extends A {
		private String a = "c";

		@Override
		public void print() {
			System.out.println(a);
		}
	}

	public static void main(String[] args) {
		TestGeneric t = new TestGeneric();
		List<A> aList = new ArrayList<>();
		aList.add(t.new A());
		processAllSubclass(aList);
		// processAllSuperclassOfB(aList);

		List<B> bList = new ArrayList<>();
		bList.add(t.new B());
		processAllSubclass(bList);
		// processAllSuperclassOfB(bList);

		List<C> cList = new ArrayList<>();
		cList.add(t.new C());
		processAllSubclass(cList);
		// processAllSuperclassOfB(cList); Compile time error
	}

	public static void staticTestMethod() {
		System.out.println("Invoking staticTestMethod method");
	}

	public void instanceTestMethod() {
		System.out.println("Invoking instanceTestMethod method");
	}

	private static void processAllSubclass(List<? extends A> listOflist) {
		for (A l : listOflist) {
			l.print();
			System.out.println(l.a);
			// if (l instanceof A) {
			// System.out.println(((A) l).a);
			// }
			// if (l instanceof B) {
			// System.out.println(((B) l).a);
			// }
			// if (l instanceof C) {
			// System.out.println(((C) l).a);
			// }
		}
	}

	private static void processAllSuperclassOfB(List<? super B> listOflist) {
		for (Object l : listOflist) {
			if (l instanceof A) {
				System.out.println(((A) l).a);
			}
			if (l instanceof B) {
				System.out.println(((B) l).a);
			}
			if (l instanceof C) {
				System.out.println(((C) l).a);
			}
		}
	}
}
