package quiz01;

public class Person {
	
	//- 세 클래스는 공통적으로 이름과 나이를 가진다.
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 세 클래스는 공통적으로 info() 메서드를 가지고 있다.
	//(리턴 타입: String, 이름: XXX, 나이: XXX )
	void info() {
		System.out.printf("이름: %s 나이: %d ", name, age);
	}

}
