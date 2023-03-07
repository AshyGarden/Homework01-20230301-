package quiz01;

public class Student extends Person {
	
	//학생은 학번(studentId)을 가지고 있다
	String studentId;
	
	public Student(String name, int age) {
		super(name, age);
		studentId = "a001"; 
	}

	@Override
	void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.printf("학번: %s\n",studentId);
	}
	
	

}
