package test.java.basics;

import java.io.IOException;

public class TestClonable implements Cloneable {
	private String name = "santhosh";
	private transient String age = "27";
	private transient static String company = "ksl";
	private Address address = new Address();

	class Address {
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
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {

		TestClonable t = new TestClonable();
		System.out.println(t);
		System.out.println(t.hashCode());
		System.out.println(t.address.hashCode());
		TestClonable tt = (TestClonable) t.clone();
		System.out.println(tt);
		t.address.city="chennai";
		System.out.println(tt);
		System.out.println(tt.hashCode());
		System.out.println(tt.address.hashCode());
	}

}
