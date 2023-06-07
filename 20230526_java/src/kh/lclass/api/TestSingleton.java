package kh.lclass.api;

public class TestSingleton {
	private int a = 10;
	private static TestSingleton instance = new TestSingleton();
	
	private TestSingleton() {}
	
	public static TestSingleton getInstance() {
		return instance;
	}

	public static void setInstance(TestSingleton instance) {
		TestSingleton.instance = instance;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
