package quiz01;

public class Employee extends Person{
	//종업원은 부서 (departments)를 가지고 있다.
	String department;
	
	Employee(String name, int age) {
		// TODO Auto-generated constructor stub
		super(name, age);
		this.department = "영업부";
	}

	@Override
	void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.printf("부서: %s\n",department);
	}
	

}
