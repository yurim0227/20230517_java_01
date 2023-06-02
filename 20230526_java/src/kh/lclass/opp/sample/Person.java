package kh.lclass.opp.sample;

//import java.lang.String;

public/* final */class Person/* extends Object */ {
	private String name;	//주민등록증상이름
//	public String name;
//	protected String name;	//주민등록증상이름
	private int age;	// 만
	private char gender;	// '남'	// '여'
	
	// 기본셍성자
	public Person() {}
	
	// allArgumentsConstructor 만들어주세요.
	// allArgumentsConstructor 란 모든 매개인자를 받아서 처리하는 생성자
	// overloading 으로 생성자
	public Person(String name, int age, char gender, final int maxCnt) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	protected/* final */int getAge() {
		// 만나이계산법
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}