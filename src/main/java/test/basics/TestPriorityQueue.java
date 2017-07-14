package test.java.basics;

import java.util.PriorityQueue;
import java.util.Queue;

class Book implements Comparable<Book> {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}
}

/*
 * Santhosh -- Above compareTo defines such a way that.. Parent always less than
 * children. This order is kept always. If new element greater than parent, then
 * shifting will happen.
 * 
 */

public class TestPriorityQueue {

	public static void main(String[] args) {
		Queue<Book> queue = new PriorityQueue<Book>();
		// Creating Books
		Book b1 = new Book(1, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(2, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(3, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b4 = new Book(4, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b5 = new Book(5, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b6 = new Book(0, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		queue.add(b4);
		queue.add(b5);
		queue.add(b6);
		System.out.println("Traversing the queue elements:");
		// Traversing queue elements
		for (Book b : queue) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
		queue.remove();
		System.out.println("After removing one book record:");
		for (Book b : queue) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
	}
}