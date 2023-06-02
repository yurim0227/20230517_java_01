package kh.lclass.opp.sample;

import java.io.Serializable;

//@SuppressWarnings("serial")
public class Kh implements TestInterface, Serializable {
	// The serializable class Kh does not declare a static final serialVersionUID field of type long
//		static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250648242387486390L;
	
	public void khSpecial() {
		// java.lang.NumberFormatException: For input string: "aaa"
		// int a = Integer.parseInt("aaa");
	}
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int method3(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
//	@Override
//	public int method3() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}