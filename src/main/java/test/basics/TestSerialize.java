package test.java.basics;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialize implements Serializable {
	private String name = "santhosh";
	private transient String age = "27";
	private transient static String company = "ksl";
	private Address address = new Address();

	 class Address implements Serializable {
		private transient String city = "bangalore";
		private static final String country = "india";

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Address [city=");
			builder.append(city);
			builder.append(", country=");
			builder.append(country);
			builder.append("]");
			return builder.toString();
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestSerialize [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", company=");
		builder.append(company);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TestSerialize t = new TestSerialize();
		System.out.println(t);
		new ObjectOutputStream(out).writeObject(t);
		byte[] data = out.toByteArray();

		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(in);

		TestSerialize tt = (TestSerialize) ois.readObject();
		System.out.println(tt);
		
		
		TestSerialize ttt = new TestSerialize();
		System.out.println(ttt);
	}

}
