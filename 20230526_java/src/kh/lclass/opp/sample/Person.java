package kh.lclass.opp.sample;

import java.io.Serializable;

//import java.lang.String;

public/* final */class Person/* extends Object */ implements Serializable {
	/**
	 * 주석은 일반적으로 녹색
	 * 이것은 파란색
	 * java dpcs에 표시됨.
	 * 여기에 UID 생성날짜,누가,무엇때문에 작성하였는지를 남겨야 함.
	 */
//	private static final long serialVersionUID = 6655830439833572938L;
	private static final long serialVersionUID = -28432072104201672L;
//	private static final long serialVersionUID = -28432072104201671L;
//	private static final long serialVersionUID = -28432072104201670L;
	private String name;	//주민등록증상이름
//	public String name;
//	protected String name;	//주민등록증상이름
	private int age;	// 만
	private transient char gender;	// '남'	/ '여'
//	private transient String password;
	
	// 기본셍성자
	/*녹색*/
	/**파랑색 작성위치 여기*/
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