package quiz02;

import java.util.Arrays;
import java.util.Scanner;

public class Car {
	
	Scanner sc = new Scanner(System.in);
	private String model;  // 차 모델명
	private int speed;     // 현재속도
	private char mode;     // 변속모드(P, R, N, D)
	private boolean start; // 시동 온/오프
	
	public Car(String model) {
		this.model =model;
		mode = 'P';
		speed = 0;
		start = false;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public char getMode() {
		return mode;
	}


	public void setMode(char mode) {
		this.mode = mode;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isStart() {
		return start;
	}


	public void setStart(boolean start) {
		this.start = start;
	}

	void carStatus() {
		if(isStart() == false) {
			System.out.println("현재 차량은 시동이 걸려있지않습니다.");						
		} else {
			System.out.printf("현재 차량은 시동이 걸려있으며, 속도는 %d, 상태는 %c 입니다.\n",getSpeed(),getMode());			
		}	
	}

	/*
	 setSpeed(changeSpeed) -> 속도는 0 미만, 200 이상일 수 없습니다.
					시동이 걸려있지 않은 상태라면 속도를 지정할 수 없습니다.
					D나 R모드가 아니라면 속도를 지정할 수 없습니다.
					R모드는 속도를 40 초과해서 지정할 수 없습니다. 
	 */
	void changeSpeed() {
		if(isStart() == false) {
			System.out.println("현재 시동이 걸려있지 않습니다.");
			System.out.println("시동이 걸려있지 않은 상태라면 속도를 지정할 수 없습니다.");
			return;
		} else if(!(mode=='D'||mode=='R')) {
			System.out.println("D나 R모드가 아니라면 속도를 지정할 수 없습니다.");
			return;
		} else {
			int temp =  getSpeed(); //변경전 속도 기억
			if(mode =='R') { //R모드
				System.out.print("변경할 속도를 입력해주세요: ");
				setSpeed(sc.nextInt());
				if(getSpeed()>40 ) {
					System.out.println("R모드의 속도는 40 초과일수 없습니다.");
					setSpeed(temp);
				} else if(getSpeed() < 0) {
					System.out.println("속도는 0 미만일수 없습니다.");
					setSpeed(temp);
				} 
			} else {//D모드
				System.out.print("변경할 속도를 입력해주세요: ");
				setSpeed(sc.nextInt());
				if(getSpeed()>200) {
					System.out.println("D모드의 속도는 200 초과일수 없습니다.");
					setSpeed(temp);
				} else if(getSpeed() < 0) {
					System.out.println("속도는 0 미만일수 없습니다.");
					setSpeed(temp);
				} 		
			}	
		}
	}
	
	
	/*
	 setMode -> 전달받은 변속 모드에 따라 상태를 변경합니다.
				  지정된 값 이외의 매개값은 P 모드로 통일합니다.
	 setMode, getMode -> 기본 형태로 지정합니다.
	 */
	void modeSelecter() {
		
		if(isStart() == false) {
			System.out.println("현재 시동이 걸려있지 않습니다.");
			return;
		}
		
		System.out.printf("현재 모드: %c\n",getMode());
		char temp = getMode();
		System.out.println("주행기어(D), 후진기어(R), 주차모드(P), 중립기어(N)");
		System.out.print("변경하고하 하는 모드를 입력해주세요 :");
		setMode(sc.next().charAt(0));
		switch(getMode()) {	
		case 'D': case 'd': case 'ㅇ':
			setMode('D');
			System.out.println("주행기어(D)로 변경했습니다");
			break;

		case 'R': case 'r': case 'ㄱ':
			setMode('R');
			System.out.println("후진기어(R)로 변경했습니다");
			break;
			
		case 'N': case 'n': case 'ㅜ':
			setMode('N');
			System.out.println("중립기어(N)로 변경했습니다");
			break;
			
		case 'P': case 'p': case 'ㅔ':
			if(getSpeed() >0) {
				System.out.println("속도가 0이 아니면 주차기어로 변경할수없습니다.");
				break;
			}
			setMode('P');
			System.out.println("주차기어(P)로 변경했습니다");
			break;
		
		default:
			System.out.println("모드를 잘못입력하셨습니다.");
			setMode(temp);	
		}	
	}
	
	/*
	 void engineStart() -> 시동을 거는 기능입니다.
		1. "시동버튼을 눌렀습니다." 는 출력문 실행.
		2. 엔진오일이 주입되는 기능 실행.
		3. 엔진에 연료가 주입되는 기능 실행.
		4. 시동 온/오프 상태 변수의 값을 변경.
		5. 실린더가 움직이는 기능 실행.
		6. "시동이 걸렸습니다." 는 출력문 실행.
	 */
	void engineStart() {
		System.out.println("시동버튼을 눌렀습니다.");
		injectOil();
		injectGasoline();
		setStart(true);
		moveCylinder();
		System.out.println("시동이 걸렸습니다.");
	}
	

	//void injectGasoline() -> 엔진에 연료가 주입되는 기능입니다.
	//1. "연료가 엔진에 주입됩니다." 출력문 실행
	void injectGasoline() {
		System.out.println("연료가 엔진에 주입됩니다.");
	}
	
	//void injectOil() -> 엔진오일이 주입되는 기능입니다.
	//1. "엔진오일이 순환합니다." 출력문 실행.
	void injectOil() {
		System.out.println("엔진오일이 순환합니다.");
	}
	
	//void moveCylinder() -> 실린더가 움직이는 기능입니다.
	//1. 시동 여부에 따라 실린더의 상태를 출력합니다.
	//시동이 켜져 있다면? "실린더가 움직입니다." 출력문 실행.
	//시동이 꺼져 있다면? "실린더가 움직이지 않습니다." 출력문 실행.
	void moveCylinder() {
		if(isStart() == true)
			System.out.println("실린더가 움직입니다.");
		else
			System.out.println("실린더가 움직이지 않습니다.");
	}
	
//	void engineStop() -> 시동을 끄는 기능입니다.
//	1. 객체의 현재 속도를 확인해서 0 이상이라면 시동을 끌 수 없습니다.
//	"주행 중에는 시동을 끌 수 없습니다." 출력문 실행하고 강제 종료.
//	2. 속도가 0 이라면 변속기의 모드를 확인합니다.
//	P 모드가 아니라면 "P 모드로 먼저 변속기를 변경하세요." 출력 후 강제 종료.
//	3. 변속 모드까지 이상이 없다면 시동 온/오프 여부를 조작한 후 
//	"시동이 꺼졌습니다." 출력문 실행.
//  isStart(), setStart() -> 기본형태로 지정합니다.
	
	void engineStop() {
		if(this.getMode() == 'P') {
			System.out.println("주행을 정지합니다");
			setStart(false);
		} else if(getSpeed()>0) {
			System.out.println("주행 중에는 시동을 끌 수 없습니다.");
			return;
		} else if(this.getMode() != 'P') {
			System.out.println("P 모드로 먼저 변속기를 변경하세요.");
			return;
		} 
	}
	
}
