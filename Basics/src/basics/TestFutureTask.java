package basics;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFutureTask {
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);

	public static void main(String a[]) {
		Future<String> future = threadpool.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Task Done");
				return "";
			}

		});


		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("Task done");
				return "";
			}

		});

		threadpool.execute(futureTask);
		

		while (!future.isDone()) {
			System.out.println("Not done");
		}
		System.out.println("Done");
		
		while (!futureTask.isDone()) {
			System.out.println("Not done");
		}
		System.out.println("Done");
	}

}
