package quiz01;

public class MainClassQuiz01 {

	public static void main(String[] args) {
		Student s = new Student("홍길동",30);
		Teacher t = new Teacher("김철수",50);
		Employee e = new Employee("박영희", 25);
		
		s.info();
		t.info();
		e.info();
	}

}
