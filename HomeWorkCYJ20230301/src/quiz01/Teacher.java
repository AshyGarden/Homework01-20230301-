package quiz01;

public class Teacher extends Person{
	//선생은 담당 과목(subject)를 가지고 있다
	String subject;
	
	public Teacher(String name, int age) {
		super(name, age);
		subject="수학";
	}

	@Override
	void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.printf("과목: %s\n",subject);
	}
	
	

}
