package quiz02;



public class MainClassQuiz02 {

	public static void main(String[] args) {
		
		
		Car c = new Car("시뮬레이션 가솔린 차량G");
		int button;	
		
		System.out.println("착석완료");
		System.out.printf("%s의 운전준비가 완료되었습니다.\n",c.getModel());
		
		drive: while(true) {
			System.out.println("-------------------------------------");
			c.carStatus();
			System.out.println("하고자 하는 행동을 실행해주세요");
			System.out.print("1:엔진시동   2:모드조절  3:속도조절\n4:가솔린 주입 5:엔진오일 주입 6:시동정지 9:시뮬레이션 종료\n");
			System.out.print("명령입력: ");
			button = c.sc.nextInt();
			System.out.println();
			
			switch(button) {		
			case 1: //엔진시동
				System.out.println("운전 시작!"); 
				c.engineStart();
				break;
			case 2: //모드조절
				c.modeSelecter();
				break;
			
			case 3:	//속도조절
				c.changeSpeed();
				break;

			case 4:	//연료주입(가솔린)
				if(c.getSpeed() == 0) {
					c.injectGasoline();
				} else {
					System.out.println("주행중에는 연료를 공급할 수 없습니다!");
				}
				break;
						
			case 5:	//엔진오일주입
				if(c.getSpeed() == 0) {
					c.injectOil();
				} else {
					System.out.println("주행중에는 엔진오일을 주입할수 없습니다!");
				}
				break;
				
			case 6:	//시동정지
				c.engineStop();
				break;		
				
			case 9:
				break drive;
				
			default:
				System.out.println("다시입력해주세요");
				
			}		
		}
		
		
	}

}
