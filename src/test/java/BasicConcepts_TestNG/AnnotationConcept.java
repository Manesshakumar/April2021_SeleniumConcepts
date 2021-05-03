package BasicConcepts_TestNG;

import org.testng.annotations.Test;

public class AnnotationConcept {
	
	
	
	@Test(priority = 1)
	public void m1() {
		System.out.println("m1 method");
	}

	
	@Test(dependsOnMethods = "b1")
	public void a1() {
		System.out.println("a1 method");
	}
	
	
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	public void b1() {
		int m = 9/0;
		System.out.println("b1 method");
	}
	
	
	@Test(enabled = false)
	public void c1() {
		System.out.println("c1 method");
	}
	
}
