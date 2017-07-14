package test.java.basics;

import java.lang.annotation.Annotation;

@TestAnnotation
public class TestAnnotationUsage {
	public void testAnnotation() {

		Annotation[] arr = this.getClass().getAnnotations();

		System.out.println(arr.length);
		for (Annotation ann : arr) {
			if (ann instanceof TestAnnotation) {
				System.out.println("Yes");
			}
		}

	}

	public static void main(String[] args) {
		TestAnnotationUsage t = new TestAnnotationUsage();
		t.testAnnotation();
	}
}
