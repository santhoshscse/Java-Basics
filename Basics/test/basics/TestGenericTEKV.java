package test.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class A<T> {
	T obj;
	Map map;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public <K, V> Map<K, V> getMap() {
		return map;
	}

	public <K, V> void addToMap(K k, V v) {
		if (this.map == null) {
			this.map = new HashMap<K, V>();
		}
		this.map.put(k, v);
	}

}

public class TestGenericTEKV {
	public static void main(String[] args) {
		classGeneric();
		methodGeneric();
		mapGeneric();
	}

	private static void mapGeneric() {
		A<String> str = new A<>();
		str.addToMap(1, "sa");
		str.addToMap(2, "san");
		A<Integer> in = new A<>();
		in.addToMap("a", 1);
		in.addToMap("b", 2);
		System.out.println(str.getMap());
		System.out.println(in.getMap());
	}

	private static void methodGeneric() {
		List<String> list = new ArrayList<>();
		list.add("santhosh");
		list.add("ksl");
		print(2, list);
	}

	private static void classGeneric() {
		A<String> str = new A<>();
		str.setObj("san");
		A<Integer> in = new A<>();
		in.setObj(29);

		System.out.println(str.getObj());
		System.out.println(in.getObj());
	}

	private static <T, E> void print(T obj, List<E> list) {
		System.out.println(obj);
		for (E t : list) {
			if (t.equals(obj)) {
				System.out.println("equal " + t);
			} else {
				System.out.println("not-equal " + t);
			}
		}

	}
}
