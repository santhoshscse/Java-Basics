package test.java.basics;

import static spark.Spark.get;

import java.util.ArrayList;

public class Server {
	public static void main(String[] args) {
		System.out.println("Hello");
		get("/hello", (req, res) -> "Hello World");
		arg();
		
		
	}

	private static void arg(String... args){
//		List<String> l = new ArrayList<>(4);
//		l.add("1");
//		l.add("1");
//		l.add(1,"2");
//		l.add("1");
//		Iterator<String> it = l.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//			it.remove();
//		}
//		System.out.println(l);
//		for (String d : l){
//			System.out.println(d);
//			l.remove(d);
//		}
//		System.out.println(l);
		
		
		ArrayList al=new ArrayList();//creating old non-generic arraylist 
		al.add("s");
		al.add(1);
		System.out.println(al);
		
		String aaa = "ss";
	}
}