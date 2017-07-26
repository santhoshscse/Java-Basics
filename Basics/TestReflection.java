
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflection {
	public static void main(String[] args) {
		TestReflection t = new TestReflection();
		t.testReflection();

	}

	private void testReflection() {
		System.out.println(this.getClass().getName());

		testModifiers();

		testMethods();

		testPublicMethodWithParam(1);

		testForName();

		testClassLoading();
	}

	private void testClassLoading() {
		ClassLoader loader = this.getClass().getClassLoader();
		try {
			Class c = loader.loadClass("test.TestGeneric");
			System.out.println(c.getName());
			c.getDeclaredMethod("staticTestMethod", null).invoke(null, null);
			Method instanceMethod = c.getDeclaredMethod("instanceTestMethod", null);
			instanceMethod.invoke(c.newInstance(), null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void testForName() {
		try {
			Class<TestReflection> myclass = (Class<TestReflection>) Class.forName("test.TestReflection");
			System.out.println(myclass.getSimpleName());

			Class<String> intArrClass = (Class<String>) Class.forName("[I");
			System.out.println(intArrClass.getSimpleName());

			Class intClass = Class.forName("I");
			System.out.println(intClass.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private <E> void testForNameUsingGenerics(E ele) {

	}

	public void testPublicMethodWithParam(Integer i) {
		try {
			Method me1 = this.getClass().getDeclaredMethod("testPublicMethodWithParam", new Class[] {});
			System.out.println(me1.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Method me1 = this.getClass().getDeclaredMethod("unknown", new Class[] {});
			System.out.println(me1.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Method me1 = this.getClass().getMethod("testPublicMethodWithParam", Integer.class);
			System.out.println(me1.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testModifiers() {
		int modifier = this.getClass().getModifiers();

		System.out.println(Modifier.isAbstract(modifier));
		System.out.println(Modifier.isPrivate(modifier));
		System.out.println(Modifier.isProtected(modifier));
		System.out.println(Modifier.isPublic(modifier));

	}

	private void testMethods() {
		Method[] meArr = this.getClass().getDeclaredMethods();
		System.out.println(meArr.length);
		for (Method m : meArr) {
			System.out.print(m.getName() + "-");
			if (m.getParameters().length > 0) {
				System.out.println(m.getParameterTypes()[0]);
			}
			System.out.println();
		}
	}
}
